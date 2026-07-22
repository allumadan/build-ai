package com.buildguard.ai;

public class AiRequest {

    private String report;
    private String pdf_path;

    public AiRequest() {
    }

    public AiRequest(String report, String pdf_path) {
        this.report = report;
        this.pdf_path = pdf_path;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getPdf_path() {
        return pdf_path;
    }

    public void setPdf_path(String pdf_path) {
        this.pdf_path = pdf_path;
    }
}