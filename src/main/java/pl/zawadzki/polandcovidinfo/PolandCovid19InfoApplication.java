package pl.zawadzki.polandcovidinfo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import pl.zawadzki.polandcovidinfo.pojo.InfectedByRegion;
import pl.zawadzki.polandcovidinfo.pojo.Infections;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PolandCovid19InfoApplication extends Application {

    public static void main(String[] args) {
        SpringApplication.run(PolandCovid19InfoApplication.class, args);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                dataList()
        );

        PieChart pieChart = new PieChart(pieData);

        Group root = new Group(pieChart);
        Scene scene = new Scene(root, 600,400);
        stage.setTitle("Covid19 in Poland");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    private List<PieChart.Data> dataList(){

        RestTemplate restTemplate = new RestTemplate();
        List<PieChart.Data> values = new ArrayList<>();
        Infections infections = restTemplate.getForObject("http://localhost:8080/api/getInfo", Infections.class);

        List<InfectedByRegion> infectionsValues = infections.getInfectedByRegion();

        infectionsValues.forEach(v -> values.add(new PieChart.Data(v.getRegion()
                + " " + v.getInfectedCount()
                ,v.getInfectedCount())));

        return values;
    }

}
