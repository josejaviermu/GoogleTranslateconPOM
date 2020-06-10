
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {

    private static WebDriver robot;
    String rutaEjecutableNavegador = "C:/Users/jose.martinezu/Documents/eclipse-workspace/Drivers/chromedriver.exe";
    String navegadorAUtilizar = "webdriver.chrome.driver";
    WebDriver driver;
    By presionarBotonBuscar = By.xpath("//input[@id='fakebox-input']");
    //private WebDriver robot;
    By seleccionarCampoBusqueda = By.xpath("//textarea[@id='source']");
//    By seleccionarCampoBusqueda = By.id("input-wrap");
    String ingresarConsulta = "Hello";

    public static WebDriver crearRobot() {
        ChromeDriver bot = new ChromeDriver();
        return bot;
    }

    @Before
    public void setUp(){
        abrirNavegador(navegadorAUtilizar, rutaEjecutableNavegador);

        this.robot = crearRobot();
    }

    @After
    public void tearDown() throws Exception {
        this.robot.quit();
    }

    @Test
    public void webdriverFirefox() throws InterruptedException {
/*
        System.setProperty("webdriver.gecko.driver","C:/Users/jose.martinezu/Documents/eclipse-workspace/Drivers/geckodriver.exe");


        WebDriver driver = new FirefoxDriver();
        driver.get("https://testingenesp.github.io");
        driver.quit();
*/

 //       System.setProperty(navegadorAUtilizar,rutaEjecutableNavegador);
 //       WebDriver driver;
 //       driver = new ChromeDriver();
        robot.get("https://translate.google.com/");
        System.out.println(robot.getTitle());

        //robot.findElement(By.xpath("//div[@class='gb_zc']//*[local-name()='svg']")).click();
//div[@class='gb_1c gb_8c gb_9c']
//        robot.findElement(By.xpath("//div[@class='gb_1c gb_8c gb_9c']")).click();


//        robot.findElement(By.xpath("//div[@id='input-wrap']")).click();

//        robot.findElement(By.xpath("//textarea[@id='source']")).sendKeys("Hola");

        campoBusquedaYTextoAConsultar(seleccionarCampoBusqueda, ingresarConsulta);

        Thread.sleep(1000);

        String traduccion = robot.findElement(By.xpath("//div[@class='result-shield-container tlid-copy-target']")).getText();

        System.out.println(traduccion);

        //Thread.sleep(1000);
        //Assert.assertArrayEquals(new String[][]{new String[]{"Igual"}},"Hola",traduccion);



        Assert.assertEquals("Igual","Hola",traduccion);



        //*[@id="gbwa"]/div/a/svg/path
        //presionarBotonBusqueda(presionarBotonBuscar);

        //robot.quit();

    }

    private void campoBusquedaYTextoAConsultar(By seleccionarCampoBusqueda, String ingresarConsulta) {
        robot.findElement(seleccionarCampoBusqueda).sendKeys(ingresarConsulta);
    }

    private void abrirNavegador(String navegadorAUtilizar, String rutaEjecutableNavegador) {
        System.setProperty(navegadorAUtilizar, rutaEjecutableNavegador);
    }

    public static void presionarBotonBusqueda(By presionarBotonBuscar) {
        robot.findElement(presionarBotonBuscar).click();
    }
}
