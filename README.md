# The test automation project for [ITFinland website](https://itfinland.com/)


___

## The project is done with the following technologies:

<p  align="center"

<code>
<img width="5%" title="Java" src="images/logo/Java_icon.png">
<img width="5%" title="Gradle" src="images/logo/Gradle_icon.svg">
<img width="5%" title="IntelliJ IDEA" src="images/logo/Intellij_icon.png">
<img width="5%" title="Selenide" src="images/logo/Selenide_icon.svg">
<img width="5%" title="Selenoid" src="images/logo/Selenoid_icon.svg">
<img width="5%" title="JUnit5" src="images/logo/JUnit5_icon.png">
<img width="5%" title="Github" src="images/logo/Github_icon.png">
<img width="5%" title="Jenkins" src="images/logo/Jenkins_icon.svg">
<img width="5%" title="Allure Report" src="images/logo/Allure_Report_icon.svg">
<img width="5%" title="Allure TestOps" src="images/logo/Allure_TestOps_icon.svg">
<img width="5%" title="Telegram" src="images/logo/Telegram_icon.png">
<img width="5%" title="Jira" src="images/logo/Jira_icon.png">
</code>
</p>


___

## The list of tests grouped by a tag parameter:

**"all_tests"** - includes all tests in the project (tags "main_page" and "top_menu"):

<details>
<summary>"main_page" - smoke tests:</summary>

+ Page title should have header 'ITFinland'
+ Check Main page is displayed
+ Check the top menu contains 3 items
+ Check the button for opening the Application form
+ Page console log should not have errors

</details>

<details>
<summary>"top_menu" - tests for top menu items:</summary>

+ Check the 'For companies' item
+ Check the 'For IT professionals' item
+ Check the 'Contact us' item

</details>


___

## Run tests from terminal locally

### Run tests with filled remote properties:

```bash
gradle clean test
```

### Run tests without filled remote properties:

```bash
gradle clean
test
-Dtag=${tag}
-Denvironment=${ENVIRONMENT}
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView=${BROWSER_MOBILE}
-DURL=${REMOTE_DRIVER_URL}
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/
-Dthreads=${THREADS}
```

where:
> + tag - :point_up: [The list of tests grouped by a tag parameter](#the-list-of-tests-grouped-by-tag-parameter) selected test suites which will be run in the build (by default - all_tests)
> + environment - environment, where build will be run:
    >
* `prod` - production (by default)
>   * `dev` - staging for development
> + browser - browser for running tests (by default - chrome)
> + browserVersion - version of a selected browser (by default - 91.0)
> + browserSize - size of a selected browser (by default - 1920x1080)
> + browserMobileView - phone model for running mobile tests (by default - empty)
> + URL - address of a remote server, where build will be run (by default - selenoid.autotests.cloud)
> + videoStorage - storage of run tests videos (by default - selenoid.autotests.cloud/video/)
> + threads - the number of threads for running tests (by default - 5)

### Serve report:

```bash
allure serve build/allure-results
```


___

## Results analysis

The test results can be found in:
+ [Jenkins](#jenkins)
+ [Allure Report](#allure-report)
+ [Allure TestOps](#allure-testOps)
+ [Jira](#jira)


### [Jenkins](https://jenkins.autotests.cloud/job/09-elenakomarova-itfinland-project-ui/build?delay=0sec)

For the running autotests in Jenkins, you can specify the parameters described
in :point_up:  [Run tests without filled remote properties](#run-tests-without-filled-remote-properties).

After selecting the necessary parameters, you need to click the Submit (Собрать) button.

<p align="center">
  <img src="images/screens/Jenkins_parameters.PNG">
</p>

Once the launch is finished you may watch statistics and open the `Allure Report` <img width="2%" title="Allure Report" src="images/logo/Allure_Report_icon.svg">

<p align="center">
  <img src="images/screens/Jenkins_statistic.PNG">
</p>

### Allure Report

Here are the examples of a report about test build with grouping by tags (:point_up: [The list of tests grouped by tag parameter](#the-list-of-tests-grouped-by-tag-parameter))

:arrow_right: [The launch with results for tag = main_page](https://jenkins.autotests.cloud/job/09-elenakomarova-itfinland-project-ui/32/allure/)

<p align="center">
  <img src="images/screens/Allure_results_2.PNG">
</p>

:arrow_right: [The launch with results for tag = top_menu](https://jenkins.autotests.cloud/job/09-elenakomarova-itfinland-project-ui/33/allure/)

<p align="center">
  <img src="images/screens/Allure_results_1.PNG">
</p>

### Allure TestOps

Allure TestOps is used as a storage for all tests cases (automated and manual), launches, their results. You may watch statistic and reports by all launches and results

:arrow_right: Dashboard:

<p align="center">
  <img src="images/screens/Allure_TestOps_dashboard.PNG">
</p>

:arrow_right: List of launches:

<p align="center">
  <img src="images/screens/Allure_TestOps_launches.PNG">
</p>

:arrow_right: List of tests grouped by features and their history of launches:

<p align="center">
  <img src="images/screens/Allure_TestOps_test_cases.PNG">
</p>

### Jira

Also Jira integration is implemented in the project:

<p align="center">
  <img src="images/screens/Jira.PNG">
</p>


___

## Example of video with test running in Allure Report

You may see the example of a video showing the test run in Allure report.

<p align="center">
  <img src="images/screens/Test_video_example.gif">
</p>


___

## Notifications in Telegram channel

The project is configured to send notifications about the results of launches from Jenkins to Telegram channel

<p align="center">
  <img src="images/screens/Telegram_failed_notification.PNG">
</p>

<p align="center">
  <img src="images/screens/Telegram_passed_notification.PNG">
</p>



___
