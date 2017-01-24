/**
 * 
 */
package vw.hackerrank.practice.algorithms.implementation;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author vivek
 *
 */
public class DivisibleSumPairsOptimized implements Closeable {
	private InputReader in = new InputReader(System.in);
	private PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public void solve() {
		int n = in.nextInt();
		int k = in.nextInt();
		int count = 0;
		int[] arr = new int[k];
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			num %= k;
			int complement = num == 0 ? k : num;
			count += arr[k - complement];
			arr[num] += 1;
		}
		out.println(count);
	}

	@Override
	public void close() throws IOException {
		in.close();
		out.close();
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public void close() throws IOException {
			reader.close();
		}
	}

	public static void main(String[] args) throws IOException {
		try (DivisibleSumPairsOptimized instance = new DivisibleSumPairsOptimized()) {
			instance.solve();
		}
	}
}