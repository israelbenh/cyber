import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationChallenge {
    public static void main(String[] args) {
        // Configurar o caminho para o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\israe\\AppData\\Local\\Programs\\Python\\Python310\\Scripts\\chromedriver.exe");

        // Inicializar o WebDriver
        WebDriver driver = new ChromeDriver();

        // Abrir a página
        driver.get("http://demo.automationtesting.in/Register.html");

        // Definir o tamanho da janela do navegador
        Dimension size = new Dimension(1200, 1000);
        driver.manage().window().setSize(size);

        // Cenário 1: Automatizar o formulário de registro
        registerFormAutomation(driver);

        // Aguardar alguns segundos para visualizar o resultado
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void registerFormAutomation(WebDriver driver) {
        // Preencher o campo First Name
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstNameInput.sendKeys("John");

        // Preencher o campo Last Name
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastNameInput.sendKeys("Doe");

        // Preencher o campo Address
        WebElement addressInput = driver.findElement(By.tagName("textarea"));
        addressInput.sendKeys("123 Street, City");

        // Preencher o campo Email Address
        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
        emailInput.sendKeys("john.doe@example.com");

        // Preencher o campo Phone
        WebElement phoneInput = driver.findElement(By.xpath("//input[@type='tel']"));
        phoneInput.sendKeys("1234567890");

        // Selecionar a opção Female no campo Gender
        WebElement genderRadioBtn = driver.findElement(By.xpath("//input[@value='FeMale']"));
        genderRadioBtn.click();

        // Selecionar a opção Cricket no campo Hobbies
        WebElement cricketCheckbox = driver.findElement(By.xpath("//input[@value='Cricket']"));
        cricketCheckbox.click();

        // Selecionar a opção de idioma "Catalan"
        WebElement languageDropdown = driver.findElement(By.id("msdd"));
        languageDropdown.click();

        WebElement catalanOption = driver.findElement(By.xpath("//a[contains(text(),'Catalan')]"));
        catalanOption.click();

        // Selecionar a opção de habilidade "Analytics"
        Select skillsDropdown = new Select(driver.findElement(By.id("Skills")));
        skillsDropdown.selectByVisibleText("Analytics");

        // Selecionar um país na opção "Country"
        Select countryDropdown = new Select(driver.findElement(By.id("countries")));
        countryDropdown.selectByVisibleText("Select Country");

        // Preencher a data de nascimento nos campos de data
        Select yearDropdown = new Select(driver.findElement(By.id("yearbox")));
        yearDropdown.selectByVisibleText("1990");

        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));
        monthDropdown.selectByVisibleText("January");

        Select dayDropdown = new Select(driver.findElement(By.id("daybox")));
        dayDropdown.selectByVisibleText("1");

        // Preencher a senha
        WebElement passwordInput = driver.findElement(By.id("firstpassword"));
        passwordInput.sendKeys("secretpassword");

        // Confirmar a senha
        WebElement confirmPasswordInput = driver.findElement(By.id("secondpassword"));
        confirmPasswordInput.sendKeys("secretpassword");

        // Clicar no botão Submit
        WebElement submitBtn = driver.findElement(By.id("submitbtn"));
        submitBtn.click();
    }


}







