package com.wangqiang.libs.labelviewlib;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author 王强
 * @date 2013年11月28日
 * @简介 自定义log输出类
 */
public class S {
	public static final String defaultPath = Environment.getExternalStorageDirectory().getAbsolutePath()
			+ "/WQ/log/";
	public static final String tag = "smart_wq_log";
	//true 输出log
	private static final boolean logSwitch = true;

	public static final void i(String s) {
		if (logSwitch) {
            StackTraceElement stack = Thread.currentThread().getStackTrace()[3];
			Log.i(tag, stack.getFileName() + "-" + stack.getMethodName() + "-" + stack.getLineNumber() + "-->" + s);
		}
	}// end i

    public static final void i(int i){
		if (logSwitch) {
			StackTraceElement stack = Thread.currentThread().getStackTrace()[3];
			Log.i(tag, stack.getFileName() + "-" + stack.getMethodName() + "-" + stack.getLineNumber() + "-->" + i);
		}
    }

	/**
	 * 检查sd是否可用
	 * 
	 * @return SD卡存在且可用返回true
	 */
	public static final boolean checkSD() {
		return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
	}

	/**
	 * 写log日志到SD卡
	 * @param msg 信息
	 * @param savePath 保存路径
	 * @param fileName 文件名
	 * @return true 写入成功
	 */
	public static final boolean writeLogToSD(String msg, String savePath, String fileName) {
		if (!logSwitch || !checkSD()) {
			return false;
		}
		String path = (savePath == null ? defaultPath : savePath);
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		if (fileName == null) {
			fileName = "Log-" + System.currentTimeMillis() + ".txt";
		}
		try {
			FileOutputStream fos = new FileOutputStream(path + fileName);
			fos.write(msg.getBytes());
			fos.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}// end writeLogToSD
}
