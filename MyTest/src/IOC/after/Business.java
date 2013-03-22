package IOC.after;

public class Business {
	private Writer writer;
	
	public void setWriter(Writer writer) {
		this.writer = writer; 
	}
	
	public void save() {
		System.out.println("Business--save:begin");
		writer.saveToWriter();
		System.out.println("Business--save:end");
	}
}
