package enums;

public class EnumMagic {
    public enum ProviderState {
        SUCCESS(0),
        FAILURE(1),
        INCOMPLETE_DATA(-1),
        BINDING_ERROR(-2);

        private int value;
        private String message;

        private ProviderState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setMessage(String message){
            this.message = message;
        }

        public String getMessage(){
            return message;
        }
    }

    public static void main(String[] args) {
        ProviderState.SUCCESS.setMessage("test");
        System.out.println();
    }
}
