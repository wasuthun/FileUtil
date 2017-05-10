import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;



public class FileUtil
{

	public static void copy(InputStream in, OutputStream out)
	{
		try
		{
			while (true)
			{
				int c = in.read();
				if (c < 0)
					break;
				out.write(c);
			}
			in.close();
			out.close();
		} catch (IOException e)
		{
			throw new RuntimeException();
		}
	}

	public static void copy(InputStream in, OutputStream out, int blocksize)
	{
		byte[] buffer = new byte[blocksize];
		int lenght;
		try
		{
			while (true)
			{
				lenght = in.read(buffer);
				if (lenght == 0)
					break;
				out.write(buffer, 0, lenght);
			}
		} catch (IOException e)
		{
			throw new RuntimeException();
		}
	}

	public static void bcopy(InputStream in, OutputStream out)
	{
		try
		{
			BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
			PrintWriter print = new PrintWriter(out);
			while (buffer.ready())
			{
				String reader = buffer.readLine();
				print.write(reader);
			}

		} catch (IOException e)
		{
			throw new RuntimeException();
		}

	}
}