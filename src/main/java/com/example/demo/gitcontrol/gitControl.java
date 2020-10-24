package com.example.demo.gitcontrol;

import org.eclipse.jgit.api.CreateBranchCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class gitControl  {

    public void initLocal() throws IOException, URISyntaxException {
        File localpath = new File("C:/Users/Juan/IdeaProjects/parcial1/");
        try {

            Git git = Git.init().setDirectory(localpath).call();
            git.add().addFilepattern(".").call();
            git.commit().setMessage("Init").setAll(true).call();
            git.branchCreate().setForce(true).setName("Development").call();
            git.branchCreate().setForce(true).setName("Controladores").call();
            git.branchCreate().setForce(true).setName("Servicios").call();
            git.branchCreate().setForce(true).setName("Repositorios").call();
            git.branchCreate().setForce(true).setName("Entidades").call();
            git.commit().setMessage("Branches creadas").call();
            } catch (GitAPIException e) {
            e.printStackTrace();
        }
    }

    public void initRemote() throws GitAPIException {
        File localpath = new File("C:/Users/Juan/IdeaProjects/parcial1/");
        Git git =Git.init().setDirectory(localpath).call();
        try {
            List<Ref> call = git.branchList().call();

            for(Ref ref : call ){
                int i = 1;
                System.out.println("rama" + i);
                i++;
                git = Git.init().setDirectory(localpath).call();
                git.remoteAdd().setUri(new URIish("https://github.com/jattorri/parcial1.git")).setName("origin").call();
                git.push().setRemote("https://github.com/jattorri/parcial1.git").setCredentialsProvider(new UsernamePasswordCredentialsProvider("jattorri","Spektrum4512623" )).setPushAll().add(".").call();
            }

        } catch (GitAPIException | URISyntaxException e) {
            e.printStackTrace();
        }

    }


}
