# README #

This README provides instruction on running liferay-demo (myntra clone) application on local.

* What is Myntra clone ?
The Myntra clone is an e-commerce application demo project, similar to Myntra. This application is designed to implement theoretical knowledge in practical work, involving both frontend and backend development. It offer a diverse range of items across categories. Users can effortlessly place orders after creating an account, navigating through a payment section. After payment, users receive a confirmation email with order details—an elegant integration ensuring a seamless shopping experience.

### How do I get set up? ###

* Summary of set up

This application is developed ( including code writing, debugging) using IntelliJ IDEA and the "liferay-intellij-plugin" is a plugin for the IntelliJ IDEA IDE that is designed to enhance the development experience when working with Liferay. here we used liferay-intellij-plugin-2.0.5.zip.

This application requires Java 8 for compiling and running. The Gradle build generates a jar file. It can be run with Liferay Community Edition bundled with the Apache Tomcat web server which we had configured in intellij, here we used liferay-ce-portal-tomcat-7.1.2-ga3-20190107144105508.tar.gz

The view (front-end) of this application is built using HTML, CSS, JavaScript, JSP (JavaServer Pages) and Liferay tag libraries such as
> liferay-portlet - for rendering portlet content and interacting with the portal environment.
> liferay-ui - for rendering various user interface elements and components provided by Liferay, such as buttons, forms, and navigation controls.
> clay - for creating consistent and user-friendly UI elements following Liferay's design guidelines.
these libraries are imported in init.jsp page.

* Dependencies

Gradle build.gradle file has all the requires dependencies defined. Build can be kicked off without any prerequisite. All that is required is Java 8 installed on the build server, along with Gradle version 6.5 or higher.


* Database configuration

This application uses MySQL database. Here we used MySql 5.7 used to store and manage structured data, make sure that MySQL database is running before starting the application.
This application database is configured by specifying database connection details in Liferay's configuration files ie "portal-setup-wizard.properties" located in Liferay Community Edition portal (liferay-ce-portal-tomcat-7.1.2-ga3).

 
