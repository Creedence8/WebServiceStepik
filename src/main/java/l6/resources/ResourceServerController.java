package l6.resources;


/**
 * @author a.akbashev
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class ResourceServerController implements ResourceServerControllerMBean {
    private final TestResource testResource;

    public ResourceServerController(TestResource testResource) {
        this.testResource = testResource;
    }

    @Override
    public String getName() {
        return testResource.getName();
    }

    @Override
    public int getAge() {
        return testResource.getAge();
    }

    @Override
    public void setName(String name) {
        this.testResource.setName(name);
    }

    @Override
    public void setAge (int age) {
        this.testResource.setAge(age);
    }

}
