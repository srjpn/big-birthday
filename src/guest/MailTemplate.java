package guest;

public class MailTemplate {
    private final String template;

    private MailTemplate(String template) {
        this.template = template;
    }

    public static MailTemplate createTemplate(String string){
        return new MailTemplate(string.toLowerCase());
    }

    public String getTemplate() {
        return template;
    }

    public String generate(Guest guest){
        String[] fields = new String[]{"title", "first_name", "last_name", "city", "state", "country"};
        String[] fillUps = {guest.getInitial(),guest.getFirstName(),guest.getSecondName(),guest.getCity(),
                            guest.getState(),guest.getCountry()};
        String resultAddress = template;
        for (int i = 0; i <fields.length ; i++) {
            resultAddress = resultAddress.replaceAll(fields[i],fillUps[i]);
        }
        return resultAddress;
    }
}
