package esprit.pfe.esprit.pfe.services;

import javax.ejb.Remote;

import esprit.pfe.esprit.pfe.persistence.Archive;



@Remote
public interface ArchiveServiceRemote {
	public void creeArchive(Archive ar);

}
