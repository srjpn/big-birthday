package bigBirthday.printer;

import bigBirthday.People;
import bigBirthday.guest.Guest;
import bigBirthday.template.GuestTemplate;

public class LabelPrinter implements GuestPrinter {
    GuestTemplate template;

    public LabelPrinter(GuestTemplate template) {
        this.template = template;
    }

    public void print(People people){
        for (Guest guest : people) {
            System.out.println(guest.getNameCard(template));
        }
    }
}
