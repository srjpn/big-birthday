package guest.template;

import guest.specifics.Address;
import guest.specifics.Gender;
import guest.specifics.Name;

public class MailTemplate implements GuestTemplate {
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

    @Override
    public String generate(Name name, Gender gender, Address address) {
        String[] fields = new String[]{"title", "first_name", "last_name", "city", "state", "country"};
        String[] fillUps = {gender.getInitial(),name.getFirstName(),name.getSecondName(),address.getCity(),
                address.getState(),address.getCountry()};
        String resultAddress = template;
        for (int i = 0; i <fields.length ; i++) {
            resultAddress = resultAddress.replaceAll(fields[i],fillUps[i]);
        }
        return resultAddress;
    }
}
