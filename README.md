wicket-autowire [![Build Status](https://travis-ci.org/wicket-acc/wicket-autowire.png?branch=master)](https://travis-ci.org/wicket-acc/wicket-autowire)
=================================================================================================================================================

Annotation based auto wiring of wicket components. We deploy to maven central, so just add the following lines to your pom.xml:

	<dependency>
		<groupId>com.github.wicket-acc</groupId>
		<artifactId>wicket-autowire</artifactId>
		<version>0.0.3</version>
	</dependency>

To enable in your wicket application, install wicket-auto-wire in your application's init() method:

	AutoWire.install(this);

Now components are built and added to page automatically and at the right place. The wicket id is taken from the field's name:

	public class BasicPanel extends Panel {
	
		private static final long serialVersionUID = 1L;
	
		@Component
		Label label;
	
		public BasicPanel(final String id) {
			super(id);
		}
	
	}

The only precondition is a single argument constructor. For a Link we recommend to use a non-anonymous inner class.