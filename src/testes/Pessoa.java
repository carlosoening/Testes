package testes;

import javax.swing.JOptionPane;

public class Pessoa {
	private String cpf;

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setCpf(JOptionPane.showInputDialog("Informe o CPF"));
		
		while (!p.validaCpf(p.getCpf())) {
			JOptionPane.showMessageDialog(null,  "CPF inválido. Tente novamente");
			p.setCpf(JOptionPane.showInputDialog("Informe o CPF"));
		}
		
		if (p.validaCpf(p.getCpf())) {
			String cpfFormatado = p.formataCpf(p.getCpf());
			System.out.println(cpfFormatado);
		}
	}
	
	public String formataCpf(String cpf) {
		while (!cpf.matches("[0-9]+") || cpf.length() != 11) {
			JOptionPane.showMessageDialog(null,  "CPF inválido. Tente novamente");
			cpf = JOptionPane.showInputDialog("Informe o CPF");
		}
		StringBuilder cpfFormatado = new StringBuilder();
		cpfFormatado.append(cpf.substring(0, 3));
		cpfFormatado.append(".");
		cpfFormatado.append(cpf.substring(3, 6));
		cpfFormatado.append(".");
		cpfFormatado.append(cpf.substring(6, 9));
		cpfFormatado.append("-");
		cpfFormatado.append(cpf.substring(9));
		return cpfFormatado.toString();
	}
	
	public boolean validaCpf(String cpf) {
		if (!cpf.matches("[0-9]+") || cpf.length() != 11) {
			return false;
		}
		if (cpf.equals("00000000000") || cpf.equals("55555555555") ||
			cpf.equals("11111111111") || cpf.equals("66666666666") ||
			cpf.equals("22222222222") || cpf.equals("77777777777") ||
			cpf.equals("33333333333") || cpf.equals("88888888888") ||
			cpf.equals("44444444444") || cpf.equals("99999999999")) {
			return false;
		}
		char dig10, dig11;
		int soma, i, resto, peso, num;
		try {
			soma = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (cpf.charAt(i) - 48);
				soma = soma + (num * peso);
				peso--;
			}
			resto = 11 - (soma % 11);
			if (resto == 10 || resto == 11) {
				dig10 = 0;
			} else {
				dig10 = (char) (resto + 48);
			}
			
			soma = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				soma = soma + (peso * num);
				peso--;
			}
			resto = 11 - (soma % 11);
			if (resto == 10 || resto == 11) {
				dig11 = 0;
			} else {
				dig11 = (char) (resto + 48);
			}
			
			if (dig10 == cpf.charAt(9) && dig11 == cpf.charAt(10)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
