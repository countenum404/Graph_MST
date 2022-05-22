package org.rshu;

public enum Options {
    consoleOption("1"),
    fileOption("2"),
    finishOption("3");
    public final String getOption() {
        return  this.option;
    }
    Options(final String value) {
        this.option = value;
    }
    protected final String option;
}
