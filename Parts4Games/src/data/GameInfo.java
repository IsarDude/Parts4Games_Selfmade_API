package data;

public class GameInfo {
	private String hardwareRequirements;
	
	public GameInfo() {
		
	}
	
	public GameInfo(String hardwareRequirements) {
		this.hardwareRequirements = hardwareRequirements;
	}

	public String getHardwareRequirements() {
		return hardwareRequirements;
	}

	public void setHardwareRequirements(String hardwareRequirements) {
		this.hardwareRequirements = hardwareRequirements;
	}
}
