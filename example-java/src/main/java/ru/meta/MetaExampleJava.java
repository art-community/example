package ru.meta;

import static io.art.meta.model.MetaType.metaArray;
import static io.art.meta.model.MetaType.metaEnum;
import static io.art.meta.model.MetaType.metaType;

import io.art.core.property.LazyProperty;
import io.art.meta.model.InstanceMetaMethod;
import io.art.meta.model.MetaClass;
import io.art.meta.model.MetaConstructor;
import io.art.meta.model.MetaField;
import io.art.meta.model.MetaLibrary;
import io.art.meta.model.MetaMethod;
import io.art.meta.model.MetaPackage;
import io.art.meta.model.MetaParameter;
import io.art.meta.model.MetaProxy;
import io.art.meta.model.StaticMetaMethod;
import java.util.Map;
import java.util.function.Function;

@SuppressWarnings({"all","unchecked","unused"})
public class MetaExampleJava extends MetaLibrary {
  private final MetaRuPackage ruPackage = register(new MetaRuPackage());

  public MetaExampleJava(MetaLibrary... dependencies) {
    super(dependencies);
  }

  public MetaRuPackage ruPackage() {
    return ruPackage;
  }

  public static final class MetaRuPackage extends MetaPackage {
    private final MetaExampleClass exampleClass = register(new MetaExampleClass());

    private final MetaCommunicatorPackage communicatorPackage = register(new MetaCommunicatorPackage());

    private final MetaModelPackage modelPackage = register(new MetaModelPackage());

    private final MetaServicePackage servicePackage = register(new MetaServicePackage());

    private MetaRuPackage() {
      super("ru");
    }

    public MetaExampleClass exampleClass() {
      return exampleClass;
    }

    public MetaCommunicatorPackage communicatorPackage() {
      return communicatorPackage;
    }

    public MetaModelPackage modelPackage() {
      return modelPackage;
    }

    public MetaServicePackage servicePackage() {
      return servicePackage;
    }

    public static final class MetaExampleClass extends MetaClass<ru.Example> {
      private static final LazyProperty<MetaExampleClass> self = MetaClass.self(ru.Example.class);

      private final MetaConstructorConstructor constructor = register(new MetaConstructorConstructor(this));

      private final MetaMainMethod mainMethod = register(new MetaMainMethod(this));

      private MetaExampleClass() {
        super(metaType(ru.Example.class));
      }

      public static MetaExampleClass example() {
        return self.get();
      }

      public MetaConstructorConstructor constructor() {
        return constructor;
      }

      public MetaMainMethod mainMethod() {
        return mainMethod;
      }

      public final class MetaConstructorConstructor extends MetaConstructor<ru.Example> {
        private MetaConstructorConstructor(MetaClass owner) {
          super(metaType(ru.Example.class),owner);
        }

        @Override
        public ru.Example invoke(java.lang.Object[] arguments) throws Throwable {
          return new ru.Example();
        }

        @Override
        public ru.Example invoke() throws Throwable {
          return new ru.Example();
        }
      }

      public final class MetaMainMethod extends StaticMetaMethod<Void> {
        private final MetaParameter<java.lang.String[]> argumentsParameter = register(new MetaParameter<>(0, "arguments",metaArray(java.lang.String[].class, java.lang.String[]::new, metaType(java.lang.String.class))));

        private MetaMainMethod(MetaClass owner) {
          super("main",metaType(Void.class),owner);
        }

        @Override
        public java.lang.Object invoke(java.lang.Object[] arguments) throws Throwable {
          ru.Example.main((java.lang.String[])(arguments[0]));
          return null;
        }

        @Override
        public java.lang.Object invoke(java.lang.Object argument) throws Throwable {
          ru.Example.main((java.lang.String[])(argument));
          return null;
        }

        public MetaParameter<java.lang.String[]> argumentsParameter() {
          return argumentsParameter;
        }
      }
    }

    public static final class MetaCommunicatorPackage extends MetaPackage {
      private final MetaMyCommunicatorClass myCommunicatorClass = register(new MetaMyCommunicatorClass());

      private final MetaMyConnectorClass myConnectorClass = register(new MetaMyConnectorClass());

      private MetaCommunicatorPackage() {
        super("communicator");
      }

      public MetaMyCommunicatorClass myCommunicatorClass() {
        return myCommunicatorClass;
      }

      public MetaMyConnectorClass myConnectorClass() {
        return myConnectorClass;
      }

      public static final class MetaMyCommunicatorClass extends MetaClass<ru.communicator.MyCommunicator> {
        private static final LazyProperty<MetaMyCommunicatorClass> self = MetaClass.self(ru.communicator.MyCommunicator.class);

        private final MetaMyMethodMethod myMethodMethod = register(new MetaMyMethodMethod(this));

        private final MetaGetModelMethod getModelMethod = register(new MetaGetModelMethod(this));

        private MetaMyCommunicatorClass() {
          super(metaType(ru.communicator.MyCommunicator.class));
        }

        public static MetaMyCommunicatorClass myCommunicator() {
          return self.get();
        }

        public MetaMyMethodMethod myMethodMethod() {
          return myMethodMethod;
        }

        public MetaGetModelMethod getModelMethod() {
          return getModelMethod;
        }

        @Override
        public MetaProxy proxy(
            Map<MetaMethod<?>, Function<java.lang.Object, java.lang.Object>> invocations) {
          return new MetaMyCommunicatorProxy(invocations);
        }

        public final class MetaMyMethodMethod extends InstanceMetaMethod<ru.communicator.MyCommunicator, ru.model.Model> {
          private final MetaParameter<ru.model.Model> requestParameter = register(new MetaParameter<>(0, "request",metaType(ru.model.Model.class)));

          private MetaMyMethodMethod(MetaClass owner) {
            super("myMethod",metaType(ru.model.Model.class),owner);
          }

          @Override
          public java.lang.Object invoke(ru.communicator.MyCommunicator instance,
              java.lang.Object[] arguments) throws Throwable {
            return instance.myMethod((ru.model.Model)(arguments[0]));
          }

          @Override
          public java.lang.Object invoke(ru.communicator.MyCommunicator instance,
              java.lang.Object argument) throws Throwable {
            return instance.myMethod((ru.model.Model)(argument));
          }

          public MetaParameter<ru.model.Model> requestParameter() {
            return requestParameter;
          }
        }

        public final class MetaGetModelMethod extends InstanceMetaMethod<ru.communicator.MyCommunicator, ru.model.Model> {
          private MetaGetModelMethod(MetaClass owner) {
            super("getModel",metaType(ru.model.Model.class),owner);
          }

          @Override
          public java.lang.Object invoke(ru.communicator.MyCommunicator instance,
              java.lang.Object[] arguments) throws Throwable {
            return instance.getModel();
          }

          @Override
          public java.lang.Object invoke(ru.communicator.MyCommunicator instance) throws Throwable {
            return instance.getModel();
          }
        }

        public class MetaMyCommunicatorProxy extends MetaProxy implements ru.communicator.MyCommunicator {
          private final Function<java.lang.Object, java.lang.Object> myMethodInvocation;

          private final Function<java.lang.Object, java.lang.Object> getModelInvocation;

          public MetaMyCommunicatorProxy(
              Map<MetaMethod<?>, Function<java.lang.Object, java.lang.Object>> invocations) {
            super(invocations);
            myMethodInvocation = invocations.get(myMethodMethod);
            getModelInvocation = invocations.get(getModelMethod);
          }

          @Override
          public ru.model.Model myMethod(ru.model.Model request) {
            return (ru.model.Model)(myMethodInvocation.apply(request));
          }

          @Override
          public ru.model.Model getModel() {
            return (ru.model.Model)(getModelInvocation.apply(null));
          }
        }
      }

      public static final class MetaMyConnectorClass extends MetaClass<ru.communicator.MyConnector> {
        private static final LazyProperty<MetaMyConnectorClass> self = MetaClass.self(ru.communicator.MyConnector.class);

        private final MetaMyMethod myMethod = register(new MetaMyMethod(this));

        private MetaMyConnectorClass() {
          super(metaType(ru.communicator.MyConnector.class));
        }

        public static MetaMyConnectorClass myConnector() {
          return self.get();
        }

        public MetaMyMethod myMethod() {
          return myMethod;
        }

        @Override
        public MetaProxy proxy(
            Map<MetaMethod<?>, Function<java.lang.Object, java.lang.Object>> invocations) {
          return new MetaMyConnectorProxy(invocations);
        }

        public final class MetaMyMethod extends InstanceMetaMethod<ru.communicator.MyConnector, ru.communicator.MyCommunicator> {
          private MetaMyMethod(MetaClass owner) {
            super("my",metaType(ru.communicator.MyCommunicator.class),owner);
          }

          @Override
          public java.lang.Object invoke(ru.communicator.MyConnector instance,
              java.lang.Object[] arguments) throws Throwable {
            return instance.my();
          }

          @Override
          public java.lang.Object invoke(ru.communicator.MyConnector instance) throws Throwable {
            return instance.my();
          }
        }

        public class MetaMyConnectorProxy extends MetaProxy implements ru.communicator.MyConnector {
          private final Function<java.lang.Object, java.lang.Object> myInvocation;

          public MetaMyConnectorProxy(
              Map<MetaMethod<?>, Function<java.lang.Object, java.lang.Object>> invocations) {
            super(invocations);
            myInvocation = invocations.get(myMethod);
          }

          @Override
          public ru.communicator.MyCommunicator my() {
            return (ru.communicator.MyCommunicator)(myInvocation.apply(null));
          }
        }
      }
    }

    public static final class MetaModelPackage extends MetaPackage {
      private final MetaModelClass modelClass = register(new MetaModelClass());

      private MetaModelPackage() {
        super("model");
      }

      public MetaModelClass modelClass() {
        return modelClass;
      }

      public static final class MetaModelClass extends MetaClass<ru.model.Model> {
        private static final LazyProperty<MetaModelClass> self = MetaClass.self(ru.model.Model.class);

        private final MetaConstructorConstructor constructor = register(new MetaConstructorConstructor(this));

        private final MetaField<java.lang.String> valueField = register(new MetaField<>("value",metaType(java.lang.String.class),false,this));

        private final MetaToBuilderMethod toBuilderMethod = register(new MetaToBuilderMethod(this));

        private final MetaGetValueMethod getValueMethod = register(new MetaGetValueMethod(this));

        private final MetaModelBuilderClass modelBuilderClass = register(new MetaModelBuilderClass());

        private MetaModelClass() {
          super(metaType(ru.model.Model.class));
        }

        public static MetaModelClass model() {
          return self.get();
        }

        public MetaConstructorConstructor constructor() {
          return constructor;
        }

        public MetaField<java.lang.String> valueField() {
          return valueField;
        }

        public MetaToBuilderMethod toBuilderMethod() {
          return toBuilderMethod;
        }

        public MetaGetValueMethod getValueMethod() {
          return getValueMethod;
        }

        public MetaModelBuilderClass modelBuilderClass() {
          return modelBuilderClass;
        }

        public final class MetaConstructorConstructor extends MetaConstructor<ru.model.Model> {
          private final MetaParameter<java.lang.String> valueParameter = register(new MetaParameter<>(0, "value",metaType(java.lang.String.class)));

          private MetaConstructorConstructor(MetaClass owner) {
            super(metaType(ru.model.Model.class),owner);
          }

          @Override
          public ru.model.Model invoke(java.lang.Object[] arguments) throws Throwable {
            return new ru.model.Model((java.lang.String)(arguments[0]));
          }

          @Override
          public ru.model.Model invoke(java.lang.Object argument) throws Throwable {
            return new ru.model.Model((java.lang.String)(argument));
          }

          public MetaParameter<java.lang.String> valueParameter() {
            return valueParameter;
          }
        }

        public final class MetaToBuilderMethod extends InstanceMetaMethod<ru.model.Model, ru.model.Model.ModelBuilder> {
          private MetaToBuilderMethod(MetaClass owner) {
            super("toBuilder",metaType(ru.model.Model.ModelBuilder.class),owner);
          }

          @Override
          public java.lang.Object invoke(ru.model.Model instance, java.lang.Object[] arguments)
              throws Throwable {
            return instance.toBuilder();
          }

          @Override
          public java.lang.Object invoke(ru.model.Model instance) throws Throwable {
            return instance.toBuilder();
          }
        }

        public final class MetaGetValueMethod extends InstanceMetaMethod<ru.model.Model, java.lang.String> {
          private MetaGetValueMethod(MetaClass owner) {
            super("getValue",metaType(java.lang.String.class),owner);
          }

          @Override
          public java.lang.Object invoke(ru.model.Model instance, java.lang.Object[] arguments)
              throws Throwable {
            return instance.getValue();
          }

          @Override
          public java.lang.Object invoke(ru.model.Model instance) throws Throwable {
            return instance.getValue();
          }
        }

        public static final class MetaModelBuilderClass extends MetaClass<ru.model.Model.ModelBuilder> {
          private static final LazyProperty<MetaModelBuilderClass> self = MetaClass.self(ru.model.Model.ModelBuilder.class);

          private final MetaField<java.lang.String> valueField = register(new MetaField<>("value",metaType(java.lang.String.class),false,this));

          private final MetaValueMethod valueMethod = register(new MetaValueMethod(this));

          private final MetaBuildMethod buildMethod = register(new MetaBuildMethod(this));

          private MetaModelBuilderClass() {
            super(metaType(ru.model.Model.ModelBuilder.class));
          }

          public static MetaModelBuilderClass modelBuilder() {
            return self.get();
          }

          public MetaField<java.lang.String> valueField() {
            return valueField;
          }

          public MetaValueMethod valueMethod() {
            return valueMethod;
          }

          public MetaBuildMethod buildMethod() {
            return buildMethod;
          }

          public final class MetaValueMethod extends InstanceMetaMethod<ru.model.Model.ModelBuilder, ru.model.Model.ModelBuilder> {
            private final MetaParameter<java.lang.String> valueParameter = register(new MetaParameter<>(0, "value",metaType(java.lang.String.class)));

            private MetaValueMethod(MetaClass owner) {
              super("value",metaType(ru.model.Model.ModelBuilder.class),owner);
            }

            @Override
            public java.lang.Object invoke(ru.model.Model.ModelBuilder instance,
                java.lang.Object[] arguments) throws Throwable {
              return instance.value((java.lang.String)(arguments[0]));
            }

            @Override
            public java.lang.Object invoke(ru.model.Model.ModelBuilder instance,
                java.lang.Object argument) throws Throwable {
              return instance.value((java.lang.String)(argument));
            }

            public MetaParameter<java.lang.String> valueParameter() {
              return valueParameter;
            }
          }

          public final class MetaBuildMethod extends InstanceMetaMethod<ru.model.Model.ModelBuilder, ru.model.Model> {
            private MetaBuildMethod(MetaClass owner) {
              super("build",metaType(ru.model.Model.class),owner);
            }

            @Override
            public java.lang.Object invoke(ru.model.Model.ModelBuilder instance,
                java.lang.Object[] arguments) throws Throwable {
              return instance.build();
            }

            @Override
            public java.lang.Object invoke(ru.model.Model.ModelBuilder instance) throws Throwable {
              return instance.build();
            }
          }
        }
      }
    }

    public static final class MetaServicePackage extends MetaPackage {
      private final MetaMyServiceClass myServiceClass = register(new MetaMyServiceClass());

      private MetaServicePackage() {
        super("service");
      }

      public MetaMyServiceClass myServiceClass() {
        return myServiceClass;
      }

      public static final class MetaMyServiceClass extends MetaClass<ru.service.MyService> {
        private static final LazyProperty<MetaMyServiceClass> self = MetaClass.self(ru.service.MyService.class);

        private final MetaConstructorConstructor constructor = register(new MetaConstructorConstructor(this));

        private final MetaMyMethodMethod myMethodMethod = register(new MetaMyMethodMethod(this));

        private final MetaGetModelMethod getModelMethod = register(new MetaGetModelMethod(this));

        private MetaMyServiceClass() {
          super(metaType(ru.service.MyService.class));
        }

        public static MetaMyServiceClass myService() {
          return self.get();
        }

        public MetaConstructorConstructor constructor() {
          return constructor;
        }

        public MetaMyMethodMethod myMethodMethod() {
          return myMethodMethod;
        }

        public MetaGetModelMethod getModelMethod() {
          return getModelMethod;
        }

        public final class MetaConstructorConstructor extends MetaConstructor<ru.service.MyService> {
          private MetaConstructorConstructor(MetaClass owner) {
            super(metaType(ru.service.MyService.class),owner);
          }

          @Override
          public ru.service.MyService invoke(java.lang.Object[] arguments) throws Throwable {
            return new ru.service.MyService();
          }

          @Override
          public ru.service.MyService invoke() throws Throwable {
            return new ru.service.MyService();
          }
        }

        public final class MetaMyMethodMethod extends InstanceMetaMethod<ru.service.MyService, ru.model.Model> {
          private final MetaParameter<ru.model.Model> modelParameter = register(new MetaParameter<>(0, "model",metaType(ru.model.Model.class)));

          private MetaMyMethodMethod(MetaClass owner) {
            super("myMethod",metaType(ru.model.Model.class),owner);
          }

          @Override
          public java.lang.Object invoke(ru.service.MyService instance,
              java.lang.Object[] arguments) throws Throwable {
            return instance.myMethod((ru.model.Model)(arguments[0]));
          }

          @Override
          public java.lang.Object invoke(ru.service.MyService instance, java.lang.Object argument)
              throws Throwable {
            return instance.myMethod((ru.model.Model)(argument));
          }

          public MetaParameter<ru.model.Model> modelParameter() {
            return modelParameter;
          }
        }

        public final class MetaGetModelMethod extends InstanceMetaMethod<ru.service.MyService, ru.model.Model> {
          private MetaGetModelMethod(MetaClass owner) {
            super("getModel",metaType(ru.model.Model.class),owner);
          }

          @Override
          public java.lang.Object invoke(ru.service.MyService instance,
              java.lang.Object[] arguments) throws Throwable {
            return instance.getModel();
          }

          @Override
          public java.lang.Object invoke(ru.service.MyService instance) throws Throwable {
            return instance.getModel();
          }
        }
      }
    }
  }
}
