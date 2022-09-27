package com.util;

import java.io.File;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.base.Base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ServerConfiguration extends Base {
	ServerSocket serverSocket;

	protected static DesiredCapabilities cap;
	protected static AppiumServiceBuilder builder;
	protected static AppiumDriverLocalService service;

	public static void startServer() {
		// Set Capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("noReset", "false");

		// Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
		builder.withAppiumJS(new File(prop.getProperty("mainJs")));
		// Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
	}

	public static void stopServer() {
		service.stop();
	}

	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (Exception e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static void init_server() {
		System.out.println("Trying to start Appium Server");
		CommandLine cmd = new CommandLine(prop.getProperty("NodePath"));
		cmd.addArgument(prop.getProperty("AppiumServerPath"));
		cmd.addArgument("--address");
		cmd.addArgument("127.0.0.1");
		cmd.addArgument("--port");
		cmd.addArgument("4723");
		DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(cmd, handler);
			Thread.sleep(30000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println("Appium server is at your service" + simpleDateFormat.format(new Date())
				+ "\n------------------------------------------------------------");
	}

	public static void tear_DownServer() {
		System.out.println("Trying to stop Appium Server");
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("Killall node");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Appium server has been stopped" + simpleDateFormat.format(new Date()));
	}
	
}
