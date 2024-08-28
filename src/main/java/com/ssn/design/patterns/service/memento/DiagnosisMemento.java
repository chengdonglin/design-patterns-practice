package com.ssn.design.patterns.service.memento;

/**
 * @Author linchengdong
 * @Date 2024-08-27 17:10
 * @PackageName:com.ssn.design.patterns.memento
 * @ClassName: ReportMemento
 * @Description: 备忘录类 -> 原始对象的状态快照
 * @Version 1.0
 */
public class DiagnosisMemento {

    private String reportContent;

    public DiagnosisMemento(String reportContent) {
        this.reportContent = reportContent;
    }

    public DiagnosisMemento() {
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
}
