package love;

import java.lang.annotation.Annotation;

public interface JacksonAnnotationValue<A extends Annotation> {
    Class<A> valueFor();
}
