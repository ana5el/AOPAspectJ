package aspects;

public aspect FirstAspect {

	pointcut pc1() : execution(* test.App.main(..));
	
	before() : pc1() {
		System.out.println("-------------------------------------------");
		System.out.println("Before main from Aspect with AspectJ syntax");
		System.out.println("-------------------------------------------");
	}
	
	after() : pc1() {
		System.out.println("------------------------------------------");
		System.out.println("After main from Aspect with AspectJ syntax");
		System.out.println("------------------------------------------");
	}
}
