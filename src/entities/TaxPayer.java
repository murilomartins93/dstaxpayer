package entities;

public class TaxPayer {

	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	public TaxPayer() {
	}

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax() {
		
		double monthSalary = salaryIncome / 12;
		
		if (monthSalary < 3000) {
			return 0.0;
		} else if (monthSalary < 5000){
			return salaryIncome * 0.1;
		} else {
			return salaryIncome * 0.2;
		}	
	}
	
	public double serviceTax() {
	
		if (servicesIncome != 0.0) {
			return servicesIncome * 0.15;
		} else {
			return 0.0;
		}	
	}
	
	public double capitalTax() {
		
		if (capitalIncome != 0.0) {
			return capitalIncome * 0.20;
		} else {
			return 0.0;
		}	
	}
	
	public double grossTax() {
		return salaryTax() + serviceTax() + capitalTax();
	}
	
	public double taxRebate() {
		
		double deduct = healthSpending + educationSpending;
		
		if (grossTax() * 0.3 < deduct) {
			return grossTax() * 0.3;
		} else {
			return deduct;		
		}
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
	
	@Override
	public String toString() {
		return "Imposto bruto total: " + String.format("%.2f", grossTax()) 
		+ "\nAbatimento: " + String.format("%.2f", taxRebate())
		+ "\nImposto devido: " + String.format("%.2f", netTax());
	}
			
}