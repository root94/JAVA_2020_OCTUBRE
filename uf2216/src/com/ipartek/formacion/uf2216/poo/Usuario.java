package com.ipartek.formacion.uf2216.poo;

import com.ipartek.formacion.uf2216.bibliotecas.ExpReg;

public class Usuario {
	// Variables de instancia
	// Fields (campos)
	private Long id;
	private String email, password;
	
	// Constructor
	public Usuario(Long id, String email, String password) {
		setId(id);
		setEmail(email);
		setPassword(password);
	}
	
	public Usuario(String email, String password) {
		this(null, email, password);
	}
	
	public Usuario() {}

	// Destructor: No se suele utilizar
	protected void finalize() {
		System.out.println("DESTRUCTOR: " + id + "," + email + "," + password);
	}
	
	// Getters y Setters
	public Long getId() {
		return id;
	}
	
	public void setId(Integer id) {
		setId((long)id);
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	/**
	 * Comprueba el email si es válido
	 * @param email
	 * @throws RuntimeException en el caso de que el Email no sea válido
	 */
	public void setEmail(String email) {
		if(email == null) {
			throw new RuntimeException("No se admiten emails nulos");
		}
		
		if(email.trim().length() == 0) {
			throw new RuntimeException("No se admite un email vacío");
		}
		
		if(!email.matches("\\s*" + ExpReg.EMAIL + "\\s*")) {
			throw new RuntimeException("No tiene el formato de un email");
		}
		
		this.email = email.trim();
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Muestra en lugar de la contraseña, el caracter sustituto
	 * @param sustituto Caracter que se va a utilizar para sustituir los caracteres de la contraseña
	 * @return Contraseña con caracter sustituto en lugar de sus caracteres originales
	 */
	
	public String getPassword(char sustituto) {
		return password.replaceAll(".", String.valueOf(sustituto));
	}
}