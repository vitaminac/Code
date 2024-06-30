package core.io;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.OutputStream;

public class NullOutputStream extends OutputStream {
    @Override
    public void write(int b) throws IOException {
    }

    @Override
    public void write(@NotNull byte[] b) throws IOException {
    }

    @Override
    public void write(@NotNull byte[] b, int off, int len) throws IOException {
    }

    @Override
    public void flush() throws IOException {
    }
}
