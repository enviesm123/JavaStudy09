package taegon.submit12.board;

public class AudioBoard extends BoardParent {
   private String audioFile;

    public AudioBoard() {
    }

    public AudioBoard(int number, String title, String date, String content) {
        super(number, title, date, content);
    }

    @Override
    public String toString() {
        return "AudioBoard{" +
                "audioFile='" + audioFile + '\'' +
                '}';
    }

    public String getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }
}
