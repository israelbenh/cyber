import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Automation2 {
    public static void main(String[] args) {
        // Configurar o caminho para o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\israe\\AppData\\Local\\Programs\\Python\\Python310\\Scripts\\chromedriver.exe");

        // Inicializar o WebDriver
        WebDriver driver = new ChromeDriver();

        // Abrir a página
        driver.get("http://demo.automationtesting.in/Register.html");

        // Cenário 2: Escrever dentro de um frame
        frameAutomation(driver);


        // Aguardar alguns segundos para visualizar o resultado
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Fechar o navegador
        driver.quit();
    }

    public static void frameAutomation(WebDriver driver) {
        // Navegar para o menu "Switch > Frames"
        WebElement switchMenu = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(switchMenu).build().perform();

        WebElement framesOption = driver.findElement(By.xpath("//a[contains(text(),'Frames')]"));
        actions.moveToElement(framesOption).click().build().perform();

        // Alternar para o frame e escrever dentro dele
        driver.switchTo().frame("singleframe");
        WebElement textField = driver.findElement(By.tagName("input"));
        textField.sendKeys("Texto no frame");
    }

    }

