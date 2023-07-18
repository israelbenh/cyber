import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Automation4 {
    public static void main(String[] args) {
        // Configurar o caminho para o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\israe\\AppData\\Local\\Programs\\Python\\Python310\\Scripts\\chromedriver.exe");

        // Inicializar o WebDriver
        WebDriver driver = new ChromeDriver();

        // Abrir a página
        driver.get("http://demo.automationtesting.in/Register.html");
        // Cenário 4: Movimentar 50% da barra do Slider
        sliderAutomation(driver);

        // Aguardar alguns segundos para visualizar o resultado
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Fechar o navegador
        driver.quit();
    }

    public static void sliderAutomation(WebDriver driver) {
        // Navegar para o menu "Widgets > Slider"
        WebElement widgetsMenu = driver.findElement(By.xpath("//a[contains(text(),'Widgets')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(widgetsMenu).build().perform();

        WebElement sliderOption = driver.findElement(By.xpath("//a[contains(text(),'Slider')]"));
        actions.moveToElement(sliderOption).click().build().perform();

        // Mover 50% da barra do Slider
        WebElement sliderBar = driver.findElement(By.xpath("//div[@id='slider']//div[@class='ui-slider-handle']"));
        int sliderWidth = sliderBar.getSize().getWidth();
        int xOffset = (int) (sliderWidth * 0.5);
        actions.dragAndDropBy(sliderBar, xOffset, 0).build().perform();
    }
}