/*
 * The MIT License
 * 
 * Copyright (c) 2004-2009, Sun Microsystems, Inc., Kohsuke Kawaguchi
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.remoting;

import javax.annotation.CheckForNull;

/**
 * {@link Command} that unexports an object.
 * @author Kohsuke Kawaguchi
 */
public class UnexportCommand extends Command {
    private final int oid;

    UnexportCommand(int oid, @CheckForNull Throwable cause) {
        this.oid = oid;
        chainCause(cause);
    }

    /**
     * @deprecated Use {@link #UnexportCommand(int, Throwable)}
     */
    @Deprecated
    public UnexportCommand(int oid) {
        this(oid,null);
    }

    @Override
    protected void execute(Channel channel) {
        channel.unexport(oid,createdAt);
    }

    @Override
    public String toString() {
        return "Unexport";
    }

    private static final long serialVersionUID = 1L;
}
