
public class test {

	public static void main(String[] args) {
		String str="it대학 1호관";
		str=str.toUpperCase();
		String str2="";
		int n=str.length();
		int cnt=0;
		while(cnt<n) {
			if(str.charAt(cnt)!=' ') {
				str2+=str.charAt(cnt++);
			}
			else cnt++;
		}
		System.out.println(str2);
	}

}
