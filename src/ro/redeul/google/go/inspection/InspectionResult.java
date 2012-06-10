package ro.redeul.google.go.inspection;

import java.util.ArrayList;
import java.util.List;

import com.intellij.codeInspection.InspectionManager;
import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.psi.PsiElement;

public class InspectionResult {
    private final InspectionManager manager;
    private final List<ProblemDescriptor> problems = new ArrayList<ProblemDescriptor>();

    public InspectionResult(InspectionManager manager) {
        this.manager = manager;
    }

    public List<ProblemDescriptor> getProblems() {
        return problems;
    }

    public void addProblem(PsiElement element, String msg, LocalQuickFix... fixes) {
        addProblem(element, element, msg, fixes);
    }

    public void addProblem(PsiElement element, String msg, ProblemHighlightType type, LocalQuickFix... fixes) {
        addProblem(element, element, msg, type, fixes);
    }

    public void addProblem(PsiElement start, PsiElement end, String msg, LocalQuickFix... fixes) {
        addProblem(start, end, msg, ProblemHighlightType.GENERIC_ERROR, fixes);
    }

    public void addProblem(PsiElement start, PsiElement end, String msg, ProblemHighlightType type, LocalQuickFix... fixes) {
        problems.add(manager.createProblemDescriptor(start, end, msg, type, true, fixes));
    }
}