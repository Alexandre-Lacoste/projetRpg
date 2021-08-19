package spring.boot.tptRpg.model;

public class Views {
	public static class ViewCommon{}
	
	public static class ViewUtilisateur extends ViewCommon{}
	
	public static class ViewPersonnage extends ViewCommon{}
	public static class ViewHero extends ViewPersonnage{}
	
	public static class ViewArme extends ViewCommon{}
	public static class ViewArmeDetail extends ViewArme{}
	
	public static class ViewArmure extends ViewCommon{}
	
	public static class ViewInventaire extends ViewPersonnage{}


}
