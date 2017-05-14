package l6.resources;

/**
 * @author a.akbashev
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
@SuppressWarnings("UnusedDeclaration")
public interface ResourceServerControllerMBean {
    String getName();

    void setName(String name);

    int getAge();

    void setAge(int age);
}
