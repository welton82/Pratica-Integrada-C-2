package com.praticaintegrada.enuns;

public enum CadastroStatus {
	NA_UNIDADE(1),//por padrao 0
	NO_DESCARTE(2),// 1
	NAO_ENCONTRADO(3); //2
	
	private int code;
	private CadastroStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static CadastroStatus valueOf(int code) {
		
		for(CadastroStatus value: CadastroStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("STATUS DO CADASTRO INVÁLIDO");
	}
	
}
