package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import utils.ExcelUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setDataProvider("LoginTestData");
        annotation.setDataProviderClass(ExcelUtil.class);
        annotation.setRetryAnalyzer(RetryFailedTests.class);
    }
}
