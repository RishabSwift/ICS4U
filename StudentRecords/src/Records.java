public class Records {

    public String input = "";

    private static Records record;

    public static void main(String[] args) {
        // Ask what they want to do

        record = new Records();
        record.beginProgram();

        // Add record

        // search student using a field
    }

    public static void setInput() {

    }

    private void beginProgram() {
        Messages.startMessage(record);
        Messages.getInput("Add|Search|Delete|View");

        switch (input.toLowerCase()) {
            case "add":
                addUser();
                break;

//            case "search":
//                searchUser();
//                break;
//
//            case "delete":
//                deleteUser();
//                break;
//
//            case "view":
//                viewUser();
//                break;
//
            default:

                break;
        }
    }

    private void addUser() {
        Student student = new Student();
        Messages.showMessage("Enter the student's first name");
        student.setFirstName(Messages.getInput(Validation.Type.ALPHA));

        Messages.showMessage("Enter the student's last name");
        student.setLastName(Messages.getInput(Validation.Type.ALPHA));

        Messages.showMessage("Enter the student's email address");
        student.setEmail(Messages.getInput(Validation.Type.EMAIL));

        Messages.showMessage("Enter the student's province");
        student.setProvince(Messages.getInput(Validation.Type.ALPHA));

        Messages.showMessage("Enter the student's postal code");
        student.setPostalCode(Messages.getInput(Validation.Type.POSTAL_CODE));

        student.toString();
    }


}
