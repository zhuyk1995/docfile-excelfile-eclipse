package myselfinterface.infoutil;

import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import myselfinterface.interfaceutil.InjectPrint;

/**
 * 编译时注解工具
 * @author 作者: ZHUYAKANG
 * @createDate 创建时间：2019年5月8日 下午4:14:46
 */
@SupportedAnnotationTypes("myselfinterface.interfaceutil.InjectPrint")
public class InjectPrintProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

		// 获取InjectPrint类型注解，然后遍历
		for(Element element : roundEnvironment.getElementsAnnotatedWith(InjectPrint.class)) {
			if(element.getKind() == ElementKind.METHOD) {
				// 强转成方法对应的element，同理，如果你的注解是一个类，那你可以强转成TypeElement
				ExecutableElement executableElement = (ExecutableElement) element;
				// 打印方法名
				System.out.println(executableElement.getSimpleName());
				// 打印返回值类型
				System.out.println(executableElement.getReturnType().toString());
				// 获取方法所有参数
				List<? extends VariableElement> params = executableElement.getParameters();
				// 遍历打印参数名
				for(VariableElement variableElement : params) {
					System.out.println(variableElement.getSimpleName());
				}
				// 打印注解的值
				System.out.println("AnnotationValue:" + executableElement.getAnnotation(InjectPrint.class).value());
			}
		}
		return false;
	}
}
