package com.ssn.design.patterns.service.memento;

/**
 * @Author linchengdong
 * @Date 2024-08-27 17:16
 * @PackageName:com.ssn.design.patterns.memento
 * @ClassName: OriginatorOrinator
 * @Description: Originator类是备忘录的原始对象，它负责创建备忘录的实例，并可以恢复到备忘录的状态：
 * @Version 1.0
 */
public class DiagnosisOrinator {

    private String diagnosisContext;


    public String getDiagnosisContext() {
        return diagnosisContext;
    }


    public void setDiagnosisContext(String diagnosisContext) {
        this.diagnosisContext = diagnosisContext;
    }

    public DiagnosisMemento createMemento() {
        return new DiagnosisMemento(diagnosisContext);
    }

    public void restoreMemento(DiagnosisMemento memento) {
        this.diagnosisContext = memento.getReportContent();
    }
}
