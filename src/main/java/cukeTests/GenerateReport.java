package cukeTests;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

/**
 * Created by amit.rawat on 21/12/15.
 */
public class GenerateReport {
    public static void GenerateMasterthoughtReport(){
        try{
            String RootDir = System.getProperty("user.dir");
            File reportOutputDirectory = new File("test-output/Masterthought");
            List<String> list = new ArrayList<String>();
            Collection<File> files = FileUtils.listFiles(new File("test-output"), new RegexFileFilter(
                    "^(.*)?\\.json$"), FileFileFilter.FILE);
            for (File file : files) {
                list.add(file.getAbsolutePath());
            }
            //list.add("target/date_calculator.json");
            //list.add("target/date_calculator2.json");

            String pluginUrlPath = "";
            String buildNumber = "1";
            String buildProject = "Cuke-NG-Maven";
            boolean skippedFails = true;
            boolean pendingFails = true;
            boolean undefinedFails = true;
            boolean missingFails = true;
            boolean flashCharts = true;
            boolean runWithJenkins = false;
            boolean highCharts = false;
            boolean parallelTesting = true;
            boolean artifactsEnabled = false;
            String artifactConfig = "";
            Configuration configuration = new Configuration(reportOutputDirectory, buildProject);
            configuration.setParallelTesting(parallelTesting);
            configuration.setRunWithJenkins(runWithJenkins);
            configuration.setBuildNumber(buildNumber);


            ReportBuilder reportBuilder = new ReportBuilder(list, configuration);

            reportBuilder.generateReports();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}