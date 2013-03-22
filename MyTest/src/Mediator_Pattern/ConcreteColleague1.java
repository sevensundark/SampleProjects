package Mediator_Pattern;

public class ConcreteColleague1 extends Colleague {

	public ConcreteColleague1(Mediator mediator) {
		super(mediator);
	}
	
	public void send(String message) {
		_mediator.send(message, this);
	}
}
