package think_in_java.chapter12;

public class DeepCopy {
	
	public static void main(String[] args) {
		OceanReading reading = new OceanReading(33.9, 100.5);
		// Now clone it:
		OceanReading r = (OceanReading) reading.clone();
		r.i = 55;
		
		System.out.println(reading.i);
		System.out.println(r.i);
		
		r.depth.xx = 77;
		
		System.out.println(reading.depth.xx);
		System.out.println(r.depth.xx);
	}
}

class DepthReading implements Cloneable {
	private double depth;
	public int xx;

	public DepthReading(double depth) {
		this.depth = depth;
		xx = 10;
	}

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
}

class TemperatureReading implements Cloneable {
	private long time;
	private double temperature;

	public TemperatureReading(double temperature) {
		time = System.currentTimeMillis();
		this.temperature = temperature;
	}

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
}

class OceanReading implements Cloneable {
	public DepthReading depth;
	private TemperatureReading temperature;
	public int i;

	public OceanReading(double tdata, double ddata) {
		temperature = new TemperatureReading(tdata);
		depth = new DepthReading(ddata);
		i = 0;
	}

	public Object clone() {
		OceanReading o = null;
		try {
			o = (OceanReading) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		// Must clone handles:
//		o.depth = (DepthReading) o.depth.clone();
		o.temperature = (TemperatureReading) o.temperature.clone();
		return o; // Upcasts back to Object
	}
}
