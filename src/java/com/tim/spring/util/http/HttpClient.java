/**
 *
 * Licensed Property to China UnionPay Co., Ltd.
 * 
 * (C) Copyright of China UnionPay Co., Ltd. 2010
 *     All Rights Reserved.
 *
 * 
 * Modification History:
 * =============================================================================
 *   Author         Date          Description
 *   ------------ ---------- ---------------------------------------------------
 *   xshu       2014-05-28       HTTP通信工具类
 * =============================================================================
 */
package com.tim.spring.util.http;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.net.ssl.HttpsURLConnection;

import com.tim.spring.util.http.BaseHttpSSLSocketFactory.TrustAnyHostnameVerifier;


public class HttpClient
{
	/**
	 * 目标地址
	 */
	private URL url;

	/**
	 * 通信连接超时时间
	 */
	private int connectionTimeout;

	/**
	 * 通信读超时时间
	 */
	private int readTimeOut;

	/**
	 * 通信结果
	 */
	private String result;

	/**
	 * 获取通信结果
	 * 
	 * @return
	 */
	public String getResult()
	{
		return result;
	}

	/**
	 * 设置通信结果
	 * 
	 * @param result
	 */
	public void setResult(String result)
	{
		this.result = result;
	}

	/**
	 * 构造函数
	 * 
	 * @param url
	 *           目标地址
	 * @param connectionTimeout
	 *           HTTP连接超时时间
	 * @param readTimeOut
	 *           HTTP读写超时时间
	 */
	public HttpClient(String url, int connectionTimeout, int readTimeOut)
	{
		try
		{
			this.url = new URL(url);
			this.connectionTimeout = connectionTimeout;
			this.readTimeOut = readTimeOut;
		}
		catch (MalformedURLException e)
		{
			System.out.println(e);
		}
	}

	/**
	 * POST 发送信息到服务端
	 * 
	 * @param data
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public int sendMap(Map<String, String> data, String encoding) throws Exception
	{
		try
		{
			HttpURLConnection httpURLConnection = createConnection(encoding);
			if (null == httpURLConnection)
			{
				throw new Exception("创建联接失败");
			}
			String sendData = this.getRequestParamString(data, encoding);
			this.requestServer(httpURLConnection, sendData, encoding);
			this.result = this.response(httpURLConnection, encoding);
			return httpURLConnection.getResponseCode();
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * POST 发送信息到服务端
	 * 
	 * @param data
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public int send(Map<String, String> data, String encoding) throws Exception
	{
		try
		{
			HttpURLConnection httpURLConnection = createConnection(encoding);
			if (null == httpURLConnection)
			{
				throw new Exception("创建联接失败");
			}

			String xmlData = createXMLdata(data);
			//String sendData = this.getRequestParamString(data, encoding);
			//System.out.println("请求报文:[" + xmlData + "]");
			this.requestServer(httpURLConnection, xmlData, encoding);
			this.result = this.response(httpURLConnection, encoding);
			//System.out.println("同步返回报文:[" + result + "]");
			return httpURLConnection.getResponseCode();
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * POST 发送信息到服务端
	 * 
	 * @param data
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public int send(byte[] messageByte, String encoding) throws Exception
	{
		try
		{
			HttpURLConnection httpURLConnection = createConnection(encoding);
			if (null == httpURLConnection)
			{
				throw new Exception("创建联接失败");
			}

			PrintStream out = null;
			try
			{
				httpURLConnection.connect();
				out = new PrintStream(httpURLConnection.getOutputStream(), false, encoding);
				out.write(messageByte);
				out.flush();

				//				PrintWriter pw = new PrintWriter(httpURLConnection.getOutputStream());
				//				pw.write("hello world,my name is noah");
				//				pw.flush();
				//				pw.close();
			}
			catch (Exception e)
			{
				throw e;
			}
			finally
			{
				if (null != out)
				{
					out.close();
				}
			}

			this.result = this.response(httpURLConnection, encoding);
			System.out.println("同步返回报文:[" + result + "]");
			return httpURLConnection.getResponseCode();
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * POST 发送信息到服务端
	 * 
	 * @param data
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public int send(String xmlData, String encoding) throws Exception
	{
		try
		{
			HttpURLConnection httpURLConnection = createConnection(encoding);
			if (null == httpURLConnection)
			{
				throw new Exception("创建联接失败");
			}

			System.out.println("请求报文:[" + xmlData + "]");
			this.requestServer(httpURLConnection, xmlData, encoding);
			this.result = this.response(httpURLConnection, encoding);
			System.out.println("同步返回报文:[" + result + "]");
			return httpURLConnection.getResponseCode();
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	private String createXMLdata(Map<String, String> data)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");
		for (Map.Entry<String, String> entry : data.entrySet())
		{
			sb.append("<");
			sb.append(entry.getKey());
			sb.append(">");
			sb.append(entry.getValue());
			sb.append("</");
			sb.append(entry.getKey());
			sb.append(">");
		}
		sb.append("</xml>");
		System.out.println("xml:" + sb.toString());
		return sb.toString();
	}

	/**
	 * 发送信息到服务端 GET方式
	 * 
	 * @param data
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public File sendGet(final String encoding) throws Exception
	{
		try
		{
			final HttpURLConnection httpURLConnection = createConnectionGet(encoding);

			if (null == httpURLConnection)
			{
				throw new Exception("创建联接失败");
			}

			if (200 != httpURLConnection.getResponseCode())
			{
				return null;
			}

			//获取文件名
			final String url = httpURLConnection.getURL().toString();
			final int nameParamIndex = url.indexOf("downloadFileName");
			String fileName = new Date().toString();
			if (nameParamIndex != -1)
			{
				final String includeNameString = url.substring(nameParamIndex);
				final int temp = includeNameString.indexOf("&");
				final String nameParam = includeNameString.substring(0, temp);
				final String[] names = nameParam.split("=");
				if (names.length > 1)
				{
					fileName = names[1];
				}
			}

			InputStream input = null;
			File directory = new File("D:" + File.separator + "alipayBill");
			if (!directory.exists())
			{
				directory.mkdirs();
			}
			final File file = new File(directory.getPath() + File.separator + fileName);
			if (!file.exists())
			{
				file.createNewFile();
			}
			final OutputStream output = new FileOutputStream(file);
			input = httpURLConnection.getInputStream();
			final byte[] b = new byte[input.available()];
			input.read(b);
			output.write(b);

			input.close();
			output.flush();
			output.close();

			return file;
		}
		catch (final Exception e)
		{
			throw e;
		}
	}

	/**
	 * 发送信息到服务端 GET方式
	 * 
	 * @param data
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public InputStream sendGet2(final String encoding) throws Exception
	{
		try
		{
			final HttpURLConnection httpURLConnection = createConnectionGet(encoding);

			if (null == httpURLConnection)
			{
				throw new Exception("创建联接失败");
			}

			if (200 != httpURLConnection.getResponseCode())
			{
				return null;
			}
			InputStream input = null;
			input = httpURLConnection.getInputStream();

			return input;
		}
		catch (final Exception e)
		{
			throw e;
		}
	}

	/**
	 * 发送信息到服务端 GET方式
	 * 
	 * @param data
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public String sendGet3(final String encoding) throws Exception
	{
		try
		{
			final HttpURLConnection httpURLConnection = createConnectionGet(encoding);
			StringBuilder sb = new StringBuilder();
			if (null == httpURLConnection)
			{
				throw new Exception("创建联接失败");
			}
			System.out.println("httpURLConnection.getResponseCode():" + httpURLConnection.getResponseCode());
			if (401 == httpURLConnection.getResponseCode())
			{
				System.out.println("没有权限访问。。。");
				return null;
			}
			if (200 != httpURLConnection.getResponseCode())
			{
				return null;
			}
			InputStream input = null;
			input = httpURLConnection.getInputStream();
			System.out.println("input:" + input);
			sb.append(new String(read(input), encoding));
			return sb.toString();
		}
		catch (final Exception e)
		{
			throw e;
		}
	}

	/**
	 * 下载文件到本地
	 * 
	 * @param data
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public InputStream downloadFile(final String encoding) throws Exception
	{
		final HttpURLConnection httpURLConnection = createConnectionGet(encoding);

		if (null == httpURLConnection)
		{
			throw new Exception("创建联接失败");
		}

		if (200 != httpURLConnection.getResponseCode())
		{
			return null;
		}
		return httpURLConnection.getInputStream();
	}

	/**
	 * @param file
	 */
	private void financeUnZipFile(final File file)
	{
		ZipFile zf = null;

		try
		{
			zf = new ZipFile(file);

			final Enumeration<? extends ZipEntry> elements = zf.entries();

			if (elements == null)
			{
				return;
			}


			while (elements.hasMoreElements())
			{
				final ZipEntry ze = elements.nextElement();

				if (ze.isDirectory())
				{
					continue;
				}

				if (!ze.getName().startsWith("INN"))
				{
					continue;
				}

				final BufferedReader br = new BufferedReader(new InputStreamReader(zf.getInputStream(ze)));

				String line;

				while ((line = br.readLine()) != null)
				{
					if (line.length() < 600)
					{
						continue;
					}
					System.out.println(line);
				}
			}


		}
		catch (final IOException e)
		{
		}
		finally
		{
			try
			{
				if (zf != null)
				{
					zf.close();
				}
			}
			catch (final IOException e)
			{
			}
		}
	}


	/**
	 * HTTP Post发送消息
	 *
	 * @param connection
	 * @param message
	 * @throws IOException
	 */
	private void requestServer(final URLConnection connection, String message, String encoder) throws Exception
	{
		PrintStream out = null;
		try
		{
			connection.connect();
			out = new PrintStream(connection.getOutputStream(), false, encoder);
			out.print(message);
			out.flush();
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (null != out)
			{
				out.close();
			}
		}
	}

	/**
	 * 显示Response消息
	 *
	 * @param connection
	 * @param CharsetName
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	private String response(final HttpURLConnection connection, String encoding) throws URISyntaxException, IOException, Exception
	{
		InputStream in = null;
		StringBuilder sb = new StringBuilder(1024);
		BufferedReader br = null;
		try
		{
			if (200 == connection.getResponseCode())
			{
				in = connection.getInputStream();
				sb.append(new String(read(in), encoding));
			}
			else
			{
				in = connection.getErrorStream();
				sb.append(new String(read(in), encoding));
			}
			System.out.println("HTTP Return Status-Code:[" + connection.getResponseCode() + "]");
			return sb.toString();
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (null != br)
			{
				br.close();
			}
			if (null != in)
			{
				in.close();
			}
			if (null != connection)
			{
				connection.disconnect();
			}
		}
	}

	public static byte[] read(InputStream in) throws IOException
	{
		byte[] buf = new byte[1024];
		int length = 0;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		while ((length = in.read(buf, 0, buf.length)) > 0)
		{
			bout.write(buf, 0, length);
		}
		bout.flush();
		return bout.toByteArray();
	}

	/**
	 * 创建连接
	 *
	 * @return
	 * @throws ProtocolException
	 */
	private HttpURLConnection createConnection(String encoding) throws ProtocolException
	{
		HttpURLConnection httpURLConnection = null;
		try
		{
			httpURLConnection = (HttpURLConnection) url.openConnection();
		}
		catch (IOException e)
		{
			System.out.println(e);
			return null;
		}
		httpURLConnection.setConnectTimeout(this.connectionTimeout);// 连接超时时间
		httpURLConnection.setReadTimeout(this.readTimeOut);// 读取结果超时时间
		httpURLConnection.setDoInput(true); // 可读
		httpURLConnection.setDoOutput(true); // 可写
		httpURLConnection.setUseCaches(false);// 取消缓存
		httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=" + encoding);
		httpURLConnection.setRequestMethod("POST");
		if ("https".equalsIgnoreCase(url.getProtocol()))
		{
			HttpsURLConnection husn = (HttpsURLConnection) httpURLConnection;
			husn.setSSLSocketFactory(new BaseHttpSSLSocketFactory());
			husn.setHostnameVerifier(new TrustAnyHostnameVerifier());//解决由于服务器证书问题导致HTTPS无法访问的情况
			return husn;
		}
		return httpURLConnection;
	}

	/**
	 * 创建连接
	 *
	 * @return
	 * @throws ProtocolException
	 */
	private HttpURLConnection createConnectionGet(String encoding) throws ProtocolException
	{
		HttpURLConnection httpURLConnection = null;
		try
		{
			httpURLConnection = (HttpURLConnection) url.openConnection();
		}
		catch (IOException e)
		{
			System.out.println(e);
			return null;
		}
		httpURLConnection.setConnectTimeout(this.connectionTimeout);// 连接超时时间
		httpURLConnection.setReadTimeout(this.readTimeOut);// 读取结果超时时间
		httpURLConnection.setUseCaches(false);// 取消缓存
		httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=" + encoding);
		httpURLConnection.setRequestMethod("GET");
		if ("https".equalsIgnoreCase(url.getProtocol()))
		{
			HttpsURLConnection husn = (HttpsURLConnection) httpURLConnection;
			husn.setSSLSocketFactory(new BaseHttpSSLSocketFactory());
			husn.setHostnameVerifier(new TrustAnyHostnameVerifier());//解决由于服务器证书问题导致HTTPS无法访问的情况
			return husn;
		}
		return httpURLConnection;
	}

	/**
	 * 将Map存储的对象，转换为key=value&key=value的字符
	 *
	 * @param requestParam
	 * @param coder
	 * @return
	 */
	private String getRequestParamString(Map<String, String> requestParam, String coder)
	{
		if (null == coder || "".equals(coder))
		{
			coder = "UTF-8";
		}
		StringBuffer sf = new StringBuffer("");
		String reqstr = "";
		if (null != requestParam && 0 != requestParam.size())
		{
			for (Entry<String, String> en : requestParam.entrySet())
			{
				try
				{
					sf.append(en.getKey() + "="
							+ (null == en.getValue() || "".equals(en.getValue()) ? "" : URLEncoder.encode(en.getValue(), coder)) + "&");
				}
				catch (UnsupportedEncodingException e)
				{
					System.out.println(e);
					return "";
				}
			}
			reqstr = sf.substring(0, sf.length() - 1);
		}
		System.out.println("请求报文(已做过URLEncode编码):[" + reqstr + "]");
		return reqstr;
	}

}
