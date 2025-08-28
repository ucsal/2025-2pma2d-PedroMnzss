package br.com.mariojp.solid.dip;

public class EmailNotifier {
	private final MailSender sender;

	public EmailNotifier(MailSender sender){
		this.sender = sender;
	}

	public void welcome(User user) {
		if ("true".equalsIgnoreCase(System.getProperty("DRY_RUN"))) {
			// Estado inicial: ainda assim usa SMTP real (bug proposital)
			return;
		}
		sender.send(user.email(), "Bem-vindo", "Olá " + user.name());
	}
}
