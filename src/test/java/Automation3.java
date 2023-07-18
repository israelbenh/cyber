import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Automation3 {
    public static void main(String[] args) {
        // Configurar o caminho para o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\israe\\AppData\\Local\\Programs\\Python\\Python310\\Scripts\\chromedriver.exe");

        // Inicializar o WebDriver
        WebDriver driver = new ChromeDriver();

        // Abrir a página
        driver.get("http://demo.automationtesting.in/Register.html");
        // Cenário 3: Inserir data de nascimento nos campos do DatePicker
        datePickerAutomation(driver);

        // Aguardar alguns segundos para visualizar o resultado
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Fechar o navegador
        driver.quit();
    }
    public static void datePickerAutomation(WebDriver driver) {
        // Navegar para o menu "Widgets > Datepicker"
        WebElement widgetsMenu = driver.findElement(By.xpath("//a[contains(text(),'Widgets')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(widgetsMenu).build().perform();

        WebElement datepickerOption = driver.findElement(By.xpath("//a[contains(text(),'Datepicker')]"));
        actions.moveToElement(datepickerOption).click().build().perform();


        // Preencher a data de nascimento nos campos
        WebElement dateInput = driver.findElement(By.id("datepicker1"));
        dateInput.sendKeys("01/01/1996");


        WebElement alternateDateInput = driver.findElement(By.id("datepicker2"));
        alternateDateInput.sendKeys("01/02/1990");
    }

}