public class MailTemplate {
    String template;

    private MailTemplate(String template) {
        this.template = template;
    }

    public static MailTemplate createTemplate(String string){
        return new MailTemplate(string.toLowerCase());
    }

    public String getTemplate() {
        return template;
    }

    public String generate(MailingAddress m){
        String[] fields = {"title","first_name","last_name","city","state","country"};
        String[] fillUps = {m.gender.getInitial(),m.name.firstName,m.name.secondName,m.address.getCity(),
                            m.address.getState(),m.address.getCountry()};
        String resultAddress = template;
        for (int i = 0; i <fields.length ; i++) {
            resultAddress = resultAddress.replaceAll(fields[i],fillUps[i]);
        }
        return resultAddress;
    }
}
