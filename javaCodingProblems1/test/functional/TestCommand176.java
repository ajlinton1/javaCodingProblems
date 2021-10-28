package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCommand176 {

    @Test
    public void testCommand() {
        HardDisk hd = new HardDisk();
        Sequence sequence = new Sequence();
        sequence.recordSequence(hd::copy);
        sequence.recordSequence(hd::delete);
        sequence.recordSequence(hd::move);
        sequence.recordSequence(hd::delete);
        sequence.runSequence();
    }

    public interface IODevice {
        void copy();
        void delete();
        void move();
    }

    public class HardDisk implements IODevice {

        @Override
        public void copy() {
            System.out.println("Copying ...");
        }

        @Override
        public void delete() {
            System.out.println("Deleting ...");
        }

        @Override
        public void move() {
            System.out.println("Moving ...");
        }
    }

    public interface Command {
        public void execute();
    }

    public class Sequence {

        private final List<Command> commands = new ArrayList<>();

        public void recordSequence(Command cmd) {
            commands.add(cmd);
        }

        public void runSequence() {
            commands.forEach(Command::execute);
        }

        public void clearSequence() {
            commands.clear();
        }
    }
}
