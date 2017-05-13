/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camtel.healthcare.controls;

import com.camtel.healthcare.entities.Antecedent;

import com.camtel.healthcare.entities.Biometrie;
import com.camtel.healthcare.entities.Commentaire;
import com.camtel.healthcare.entities.ConseilHealth;
import com.camtel.healthcare.entities.Consultation;
import com.camtel.healthcare.entities.ContactService;
import com.camtel.healthcare.entities.Courrier;
import com.camtel.healthcare.entities.Docteur;
import com.camtel.healthcare.entities.DossierMedical;
import com.camtel.healthcare.entities.EmailHealthcare;
import com.camtel.healthcare.entities.Examen;
import com.camtel.healthcare.entities.FilDiscussion;
import com.camtel.healthcare.entities.ForumHealthcare;
import com.camtel.healthcare.entities.Ordonnance;
import com.camtel.healthcare.entities.Patient;
import com.camtel.healthcare.entities.Planification;
import com.camtel.healthcare.entities.Pompier;
import com.camtel.healthcare.entities.Traitement;
import com.camtel.healthcare.entities.Urgentiste;
import com.camtel.healthcare.entities.Vaccination;
import com.camtel.healthcare.services.AntecedentFacadeLocal;
import com.camtel.healthcare.services.BiometrieFacadeLocal;
import com.camtel.healthcare.services.CommentaireFacadeLocal;
import com.camtel.healthcare.services.ConseilHealthFacadeLocal;
import com.camtel.healthcare.services.ConsultationFacadeLocal;
import com.camtel.healthcare.services.ContactServiceFacadeLocal;
import com.camtel.healthcare.services.CourrierFacadeLocal;
import com.camtel.healthcare.services.DocteurFacadeLocal;
import com.camtel.healthcare.services.DossierMedicalFacadeLocal;
import com.camtel.healthcare.services.EmailHealthcareFacadeLocal;
import com.camtel.healthcare.services.ExamenFacadeLocal;
import com.camtel.healthcare.services.FilDiscussionFacadeLocal;
import com.camtel.healthcare.services.ForumHealthcareFacadeLocal;
import com.camtel.healthcare.services.OrdonnanceFacadeLocal;
import com.camtel.healthcare.services.PatientFacadeLocal;
import com.camtel.healthcare.services.PlanificationFacadeLocal;
import com.camtel.healthcare.services.PompierFacadeLocal;
import com.camtel.healthcare.services.TraitementFacadeLocal;
import com.camtel.healthcare.services.UrgentisteFacadeLocal;
import com.camtel.healthcare.services.VaccinationFacadeLocal;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author herma
 */
public class SessionControl {

    /**
     * @return the MAILER_VERSION
     */
    public static String getMAILER_VERSION() {
        return MAILER_VERSION;
    }

    /**
     * Creates a new instance of SessionControl
     */
    public SessionControl() {
    }
    
    /*DÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©claration des variables qui seront utilisÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©e pour rÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©cupÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©rer des informations tels que le matricule et le nom 
    du patient aprÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â¨s une authentification*/
    
    public  String matriculePatient;
    private String cniPatientToConsult;
    private String cniSocialPatient;
    public String nomPatient;
    public BigDecimal idPatientLocal;
    private String themeForum;
    private String subjectChoosed;
    public String SMTP_HOST1;
    public String LOGIN_SMTP1; 
    public String IMAP_ACCOUNT1;
    public String PASSWORD_SMTP1;
    private String numPatient;
    private String messageSms;
    private String nomFichierCharge;
     private String lienFichierChargeSms="C:\\www\\healthCare\\healthCare\\src\\main\\webapp\\consultations\\";
    private String lienFichierCharge="C:\\www\\healthCare\\healthCare\\src\\main\\webapp\\docEmail\\";
    //chemin vers le serveur 
    private String linkToRepConsultation = "C:\\www\\healthCare\\healthCare\\src\\main\\webapp\\consultations\\";
    private String lienFichierGenere;
    private String lienTelechargementDocConsultation = "http://172.16.72.195:8080/healthCare/consultations/"; 
    private String lienTelechargementDocOrdonnance= "http://172.16.72.195:8080/healthCare/ordonnances/"; 
     
    private String idSujetForum;
     private String[] selectedCompany;
    
    
    @EJB
    private UrgentisteFacadeLocal ufl;
    @EJB
    private PatientFacadeLocal pfl;
    @EJB
    private PompierFacadeLocal ppfl;
    @EJB
    private DocteurFacadeLocal dfl;
    @EJB
    private BiometrieFacadeLocal biometriefl;
    @EJB
    private TraitementFacadeLocal traitementfl;
    @EJB
    private AntecedentFacadeLocal antecedentfl;
    @EJB
    private ConsultationFacadeLocal consultationfl;
    @EJB
    private OrdonnanceFacadeLocal ordonnancefl;
    @EJB
    private EmailHealthcareFacadeLocal emailfl;
    @EJB
    private CourrierFacadeLocal courrierfl;
    @EJB
    private ExamenFacadeLocal examfl;
    @EJB
    private VaccinationFacadeLocal vaccinfl;
    @EJB
    private PlanificationFacadeLocal planfl;
    @EJB
    private ForumHealthcareFacadeLocal forum_health_fl;
    @EJB
    private CommentaireFacadeLocal commentfl;
    @EJB
    private FilDiscussionFacadeLocal fil_discussion_fl;
    @EJB
    private ContactServiceFacadeLocal contact_service_fl;
    @EJB
    private DossierMedicalFacadeLocal dm_fl;
    @EJB
    private ConseilHealthFacadeLocal conseilHealth_fl;
    
  //  private Email email = new Email();
    private Urgentiste urgentiste = new Urgentiste(); 
    private Antecedent antecedent = new Antecedent();
    private Patient patient = new Patient();
    private ConseilHealth conseil = new ConseilHealth();
    private ConseilHealth selectedConsultationConseil = new ConseilHealth();
     private ConseilHealth selectedExamenConseil = new ConseilHealth();
    private Patient patientToConsult = new Patient();
    private Patient patientByDoctor = new Patient();
    private Pompier pompier = new Pompier();
    private Docteur docteur = new Docteur();
    private EmailHealthcare  emailHealth = new EmailHealthcare();
    private Biometrie biometrie = new Biometrie();
    private Traitement traitement = new Traitement();
    private Consultation consultation = new Consultation();
    private Consultation selectConsultation = new Consultation();
    private Ordonnance ordonnace = new Ordonnance();
    private Courrier courrier = new Courrier();
    private Examen selectedExam = new Examen();
    private Examen examen = new Examen();
    private Vaccination vaccin = new Vaccination();
    private Planification planification = new Planification();
    private ForumHealthcare subject = new ForumHealthcare();
    private Commentaire comment = new Commentaire();
    private FilDiscussion filDiscuss = new FilDiscussion();
    private ContactService conactMsg = new ContactService();
    private DossierMedical d_medical = new DossierMedical();
    
            
    
    private List<String> images;
    private List<String> images2;
    private List<String> imagesUsager;
    private List<String> imageDemuni;
    private List<String> imagesAgri;
    private List<String> imagesWorker;
    private List<String> publicCompany;
    private List<String> privateCompany;
    private UploadedFile file;
    
    private List<Docteur> docList = new ArrayList<>();
    private List<Patient> listPatients = new ArrayList<>();
    private List<Antecedent> listAntecedents = new ArrayList<>();
    private List<Pompier> pompierList = new ArrayList<>();
    private List<Urgentiste> listUrgentiste = new ArrayList<>();
    private List<Biometrie> listBiometrie = new ArrayList<>();
    private List<Traitement> listTraitement = new ArrayList<>();
    private List<Consultation> listConsultations = new ArrayList<>();
    private List<Consultation> filteredConsultations;
    private List<Consultation> selectedConsultations;
    private List<Consultation> consultRecap = new ArrayList<>();
    private List<Ordonnance> listOrdonnances = new ArrayList<>();
    private List<Consultation> filteredOrdonnances;
    private List<Ordonnance> ordoRecap = new ArrayList<>();
    private List<Courrier> listCourriers = new ArrayList<>();
    private List<Consultation> filteredCourriers;
    private List<Examen> listExamens = new ArrayList<>();
    private List<Consultation> filteredExamens;
    private List<Vaccination> listVaccins = new ArrayList<>();
    private List<Consultation> filteredVaccins;
    private List<Planification> listPlanifications = new ArrayList<>();
    private List<ForumHealthcare> listSujetForum = new ArrayList<>();
    private List<FilDiscussion> listDiscussions = new ArrayList<>();
    private List<FilDiscussion> listDiscussionsPatient = new ArrayList<>();
    private List<FilDiscussion> listDiscussionDoctor = new ArrayList<>();
    private List<Commentaire> listComments = new ArrayList<>();
    private List<ConseilHealth> listConseilConsult = new ArrayList<>();
    private List<ConseilHealth> listConseilExamen = new ArrayList<>();
    private List<ConseilHealth> filteredConsultationConseil;
    
 //   private String linkDownload = linkToRepConsultation+patientToConsult.getCniPatient()+".pdf";
    private List<Patient> patients;
    private List<Patient> filteredPatient;
    
 private Date dateConvertible = new Date();
 private final static String MAILER_VERSION = "Java";
 private Date dateConvertibleForConsult = new Date();
    DateFormat df = new SimpleDateFormat("dd.MM.yyyy ");
        Date today = getDateConvertibleForConsult();        
        private String dateFormatteConsult = df.format(today);
        
    private Date dateConsultation = new Date();
    private Date dateConvertiblePublication  = new Date();
    private Date dateConvertibleTraitement = new Date();
    private Date dateConvertibleConsult = new Date();
    private Date dateConvertibleOrdo= new Date();
    private Date dateConvertibleExam = new Date();
    private Date dateconvertibleVaccin = new Date();
    private Date dateConvertibleRappelVaccin = new Date();
     
    @PostConstruct
    public void init() {
        
        publicCompany = new ArrayList<String>();
        publicCompany .add("Camtel");
        publicCompany .add("CNPS");
        publicCompany .add("SNI");
        publicCompany .add("SNH");
        publicCompany .add("MinSanté");
        publicCompany .add("CamPost");
        
        privateCompany= new ArrayList<String>();
        privateCompany.add("Corlay Cameroon");
        privateCompany.add("Total");
        privateCompany.add("RAZEL");
        privateCompany.add("Arab Contractor");
 
        images = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            images.add("image" + i + ".jpg");
        }
        
        images2 = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            images2.add("other" + i + ".jpg");
        }
        
        imageDemuni = new ArrayList<>();
          for(int i=1; i<=4;i++) {
            imageDemuni.add("demuni"+i+".jpg");
        }
          
        imagesAgri = new ArrayList<>();
        for(int i=1; i<=10;i++) {
            imagesAgri.add("agri"+i+".jpg");
        }
        
        imagesWorker = new ArrayList<>();
        for(int i=1; i<=7;i++) {
            imagesWorker.add("travail"+i+".jpg");
        }
        
        imagesUsager = new ArrayList<>();
        for(int i=1; i<=4;i++) {
            imagesUsager.add("espaceUsager"+i+".jpg");
        }
    }
    public String quitDoctorSession() {
        System.out.println("dans la methode de sortie de session du medecin");
        docteur = new Docteur();
        cniPatientToConsult = "";
        consultation = new Consultation();
        examen = new Examen();
        patientToConsult= new Patient();
        antecedent = new Antecedent();
        traitement = new Traitement();
        themeForum = null;
        vaccin = new Vaccination();
        return "/FR/Other/index.xhtml";
    }
    
     public String quitFireSession() {
        System.out.println("dans la methode de sortie de session du medecin");
        pompier = new Pompier();
        cniPatientToConsult = "";
        consultation = new Consultation();
        examen = new Examen();
        patientToConsult= new Patient();
        antecedent = new Antecedent();
        traitement = new Traitement();
        vaccin = new Vaccination();
        return "/FR/Other/index.xhtml";
    }
    
    public String quitNurseSession() {
        System.out.println("dans la methode de sortie de session du medecin");
        urgentiste = new Urgentiste();
        patientToConsult = new Patient();
        cniPatientToConsult = "";
        antecedent = new Antecedent();
        traitement = new Traitement();
        examen = new Examen();
        vaccin = new Vaccination();
        consultation = new  Consultation();
        return "/FR/Other/index.xhtml";
    }
    
    public String quitPatientSession() {
   
        patient = new Patient();
        antecedent = new Antecedent();
        traitement = new Traitement();
        vaccin = new Vaccination();
        consultation = new  Consultation();
        themeForum = null;
        return "/FR/Other/index.xhtml";
    }
    
    public List<String> getImages() {
        return images;
    }
    
    public List<String> getImages2() {
        return images2;
    }
    
    public void convertDateToString()
    {
        
    }
    
    public String suscribePatient(){
        System.out.println("je sors...");
        return "suscribePatient";
    } 
    
    public String suscribeDoctor(){
        
        return "suscribeDoctor";
    }
    
    public String suscribeNurse(){
      
        return "suscribeNurse";
    }
    
    public String authenPerson(){
        
        return "/FR/Other/chooseLoginMode.xhtml";
    }
    
    public String chooseSecurityPage(){
        
        return "/FR/SocialSecurity/authenSocialDoctor.xhtml";
    }
    
    public String chooseComplementPage(){
        
        return "/FR/CompSante/welcomePageComp.xhtml";
    }
    
     public String chooseUsagerPage(){
        
        return "/FR/SocialSecurity/usagerPage.xhtml";
    }
    
    public String suscribeFire(){
        
        return "suscribeFire";
    }
    
   /* public String showDetailsDiscussion( ForumHealthcare subjectSelected){
        System.out.println(subjectSelected.getSujet());
        System.out.println(subjectSelected.getDescriptionSujet());
        System.out.println(subjectSelected.getDateCreationSujet());
        
        
        listDiscussions = new ArrayList<>();
        
        List<FilDiscussion> listFilDiscuss;
        listFilDiscuss = fil_discussion_fl.findAllInverse();

            for (FilDiscussion listFilDiscuss1 : listFilDiscuss) {
                if (subjectSelected.getIdForum().toString().equals(listFilDiscuss1.getIdSujetForum())) {
                    listDiscussions.add(listFilDiscuss1);
                    subjectChoosed = listFilDiscuss1.getSujet();
                }
            }
            return "showDiscussions";
    }*/
    
      public String showDetailsDiscussionDoctor(ForumHealthcare subjectSelected){
        
       
        idSujetForum = subjectSelected.getIdForum().toString();
        System.out.println("id sujet forum :"+idSujetForum);

        List<FilDiscussion> listFilDiscuss;
        listFilDiscuss = fil_discussion_fl.findAllInverse();

            for (FilDiscussion listFilDiscuss1 : listFilDiscuss) {
                if (idSujetForum.equals(listFilDiscuss1.getIdSujetForum())) {
                    listDiscussionDoctor.add(listFilDiscuss1);
                }
            }
            return "showDiscussionDoctor";

    }
    
    public String showDetailsDiscussionPatient( ForumHealthcare subjectSelected){
        System.out.println(subjectSelected.getIdForum());
        System.out.println(subjectSelected.getDescriptionSujet());
        System.out.println(subjectSelected.getDateCreationSujet());
        
        
         idSujetForum = subjectSelected.getIdForum().toString(); 
        listDiscussionsPatient = new ArrayList<>();
        
        List<FilDiscussion> listFilDiscuss;
        listFilDiscuss = fil_discussion_fl.findAllInverse();

            for (FilDiscussion listFilDiscuss1 : listFilDiscuss) {
                if (idSujetForum .equals(listFilDiscuss1.getIdSujetForum())) {
                    listDiscussionsPatient.add(listFilDiscuss1);
                    subjectChoosed = listFilDiscuss1.getSujet();
                }
            }
            return "/FR/Patient/discussionForum.xhtml";
    }
    
    
    public String showSubjectForum() {
        listSujetForum = new ArrayList<>();
     
        List<ForumHealthcare> forumSujet;
        if(themeForum !=null)
        {
            
           forumSujet = forum_health_fl.findAllInverse();
            
           for (ForumHealthcare forumSujet1 : forumSujet) {
                if (themeForum.equals(forumSujet1.getCategorieSujet())) {
                    listSujetForum.add(forumSujet1);
                }
            }
             return "showSujet";
        }
       
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error veuillez choisir une thÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â¨matique!", "Contact admin."));
      return null;
    }
    
    
            
  
    
     public String showSubjectDoctor() {
        listSujetForum = new ArrayList<>();
      
        List<ForumHealthcare> forumSujet;
        if(themeForum !=null)
        {
            System.out.println("le theme a ete choisi");
           forumSujet = forum_health_fl.findAllInverse();
            
            for (ForumHealthcare forumSujet1 : forumSujet) {
                if (themeForum.equals(forumSujet1.getCategorieSujet())) {
                    listSujetForum.add(forumSujet1);
                }
            }
            return "showSubjectForum";
        }
       
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error veuillez choisir une thÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â¨matique!", "Contact admin."));
      return null;
    }
    
    public String showSubjectCreator()
    {
       return "showSubjectCreation";
    }
  
//--------------------------------------------------------------------------------------------------------------------------
//*************************************Search Methods*****************************
    
     public String connectDoctor() {
 
        setDocList(dfl.findAll());
  
        for(int i=0; i<getDocList().size();i++)
        {
            
            if((docteur.getMatriculeDocteur().equals(getDocList().get(i).getMatriculeDocteur()))
            &&(docteur.getMpDocteur().equals(getDocList().get(i).getMpDocteur())))
            {
                System.out.println("le docteur existe piangggggggg");
                docteur = docList.get(i);
                FacesContext context = FacesContext.getCurrentInstance(); 
                context.addMessage(null, new FacesMessage("Succes", "Correctement effectue."));  
                return "doctorPage";
            }
        }
        
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));

          return "erreur d'authentification";
    }
     

      public String connectDoctorSocialSecurity() {
 
        setDocList(dfl.findAll());
  
        for(int i=0; i<getDocList().size();i++)
        {
            
            if((docteur.getMatriculeDocteur().equals(getDocList().get(i).getMatriculeDocteur()))
            &&(docteur.getMpDocteur().equals(getDocList().get(i).getMpDocteur())))
            {
                
                docteur = docList.get(i);
                FacesContext context = FacesContext.getCurrentInstance(); 
                context.addMessage(null, new FacesMessage("Succes", "Correctement effectue."));  
                return "/FR/SocialSecurity/authenSocialPatient.xhtml";
            }
        }
        
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));

          return "erreur d'authentification";
    }

    
    
    public String connectPatient() {
 
        setListPatients(pfl.findAll());
  
        for(int i=0; i<getListPatients().size();i++)
        {
            
            if((patient.getCniPatient().equals(getListPatients().get(i).getCniPatient()))
            &&(patient.getMpPatient().equals(getListPatients().get(i).getMpPatient())))
            {
                System.out.println("le patient existe piangggggggg");
                //je set le matricule du patient et le nom dans les variables de type string dÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©clarÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©es plus haut
                matriculePatient = getListPatients().get(i).getCniPatient();
                nomPatient = getListPatients().get(i).getNomPatient();
                idPatientLocal = getListPatients().get(i).getIdPatient();
                patient = listPatients.get(i);
                FacesContext context = FacesContext.getCurrentInstance(); 
                context.addMessage(null, new FacesMessage("Succes", "Correctement effectue."));  
                return "patientPage";
            }
        }
        
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));

          return "erreur d'authentification";
    }
    
    public String connectFireFigther() {
 
        setPompierList(ppfl.findAll());
  
        for(int i=0; i<getPompierList().size();i++)
        {
            
            if((pompier.getMatriculePompier().equals(getPompierList().get(i).getMatriculePompier()))
            &&(pompier.getMpPompier().equals(getPompierList().get(i).getMpPompier())))
            {
                System.out.println("le pompier existe piangggggggg");
                pompier = getPompierList().get(i);
                FacesContext context = FacesContext.getCurrentInstance(); 
                context.addMessage(null, new FacesMessage("Succes", "Correctement effectue."));  
                return "pompierPage";
            }
        }
        
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));

          return "erreur d'authentification";
    }
    
    public String connectNurse() {
 
        setListUrgentiste(ufl.findAll());
  
        for(int i=0; i<getListUrgentiste().size();i++)
        {
            
            if((urgentiste.getMatriculeUrg().equals(getListUrgentiste().get(i).getMatriculeUrg()))
            &&(urgentiste.getMpUrgentiste().equals(getListUrgentiste().get(i).getMpUrgentiste())))
            {
                System.out.println("l'urgentiste existe piangggggggg");
                urgentiste = listUrgentiste.get(i);
                FacesContext context = FacesContext.getCurrentInstance(); 
                context.addMessage(null, new FacesMessage("Succes", "Correctement effectue."));  
                return "nursePage";
            }
        }
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));

          return "erreur d'authentification";
    }
//--------------------------------------------------------------------------------------------------------------------------
//MÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©thodes de mise ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â  zÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©ro champs
    
   public void reset() {
        RequestContext.getCurrentInstance().reset("updateMedicalDocument:panelSource");
    }

   
//************************************* Update Methods*********************************
    public void updatePatientMedDoc() {
        
        if((antecedent.getAnteChirObste().equals("")) && (antecedent.getAnteFaml().equals("")) 
          && (antecedent.getAnteMedRis().equals("")) && (antecedent.getAllergIntole().equals(""))) {
            
            
        } else
        {
            antecedent.setMatPatient(patient.getCniPatient());
            antecedent.setNomPatient(patient.getNomPatient());
            antecedentfl.create(antecedent);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Ajout des antecedents", "Correctement effectue."));

            antecedent = new Antecedent();
        }
        
        if((biometrie.getTaille().equals("")) && (biometrie.getPoids().equals("")) && 
           (biometrie.getIndicateurBio().equals("")) && (biometrie.getGroupSanguin().equals(""))) {
            
         
        } else
        {
            biometrie.setCniPatientBio(patient.getCniPatient());
            biometrie.setNomPatient(patient.getNomPatient());
            biometriefl.create(biometrie);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Ajout des informations Biometriques", "Correctement effectue"));

            biometrie = new Biometrie();
        }
        
        if(traitement.getPosologie().equals("") && traitement.getNomComprime().equals("")) {
            
        }else {
            
        traitement.setCniPatTraite(matriculePatient);
        
        DateFormat dfTrait = new SimpleDateFormat("dd/MM/yyyy ");
        Date today = getDateConvertibleTraitement();        
        String reportDateTrait = dfTrait.format(today);
        traitement.setDateDebutTrait(reportDateTrait);
        traitementfl.create(traitement);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Ajout du Traitement reussi", "Correctement effectue."));
        
        traitement = new Traitement();
        }

    }
        
    
    public void updatePatientProfile() {
        int valueAcces = 0;
         setListPatients(pfl.findAll());
  
        for (Patient patientList1 : getListPatients()) {
            if (patient.getIdPatient() == patientList1.getIdPatient()) {
                
                patientList1.setNomPatient(patient.getNomPatient());
                patientList1.setPrenomPatient(patient.getPrenomPatient());
                patientList1.setDateNaissPatient(patient.getDateNaissPatient());
                patientList1.setGenrePatient(patient.getGenrePatient());
                patientList1.setMpPatient(patient.getMpPatient());
                patientList1.setCniPatient(patient.getCniPatient());
                patientList1.setTelephonePatient(patient.getTelephonePatient());
              
                patientList1.setLieuNaissPat(patient.getLieuNaissPat());
                patientList1.setCaissePat(patient.getCaissePat());
                patientList1.setCorrespondantPat(patient.getCorrespondantPat());
                patientList1.setProfPatient(patient.getProfPatient());
                patientList1.setSituationFamPat(patient.getSituationFamPat());
                patientList1.setEmailPat(patient.getEmailPat());
                patientList1.setMedTraitPat(patient.getMedTraitPat());
                patientList1.setParticularitePat(patient.getParticularitePat());
                
                System.out.println("nom du patient: "+patientList1.getNomPatient()+"\n");
                
                pfl.edit(patientList1);
 
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Modifie avec succes", "Correctement effectue."));
            }               
        }       
           
        if(valueAcces ==1){
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));
            } 
        
        
        
    }
    
    public void updateDoctorProfile () {
        int valueAcces = 0;
        setDocList(dfl.findAll());
  
        for (Docteur docteurList1 : getDocList()) {
            if (docteur.getIdDocteur() == docteurList1.getIdDocteur()) {
                
                docteurList1.setEmail(docteur.getEmail());
                docteurList1.setAdresseProDocteur(docteur.getAdresseProDocteur());
                docteurList1.setCniDocteur(docteur.getCniDocteur());
                docteurList1.setGenreDocteur(docteur.getGenreDocteur());
                docteurList1.setMatriculeDocteur(docteur.getMatriculeDocteur());
                docteurList1.setMpDocteur(docteur.getMpDocteur());
                docteurList1.setNomDocteur(docteur.getNomDocteur());
                docteurList1.setPrenom(docteur.getPrenom());
                docteurList1.setMpDocteur(docteur.getMpDocteur());
                docteurList1.setSpecialiteDocteur(docteur.getSpecialiteDocteur());
                docteurList1.setStructureDocteur(docteur.getStructureDocteur());
                docteurList1.setTelephoneDocteur(docteur.getTelephoneDocteur());
                docteurList1.setTelphoneProfessionelDocteur(docteur.getTelphoneProfessionelDocteur());
               
                dfl.edit(docteurList1);
                valueAcces =1;
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Modifie avec succes", "Correctement effectue."));
            }
        }       
         if(valueAcces !=1){
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));
            } 
        
    }
    
    public void updateNurseProfile () {
        int valueAcces = 0;
        listUrgentiste = ufl.findAll();
  
        for (Urgentiste urgentisteList1 : getListUrgentiste()) {
            if (urgentiste.getIdUrg() == urgentisteList1.getIdUrg()) {
                
                urgentisteList1.setAdresseUrg(urgentiste.getAdresseUrg());
                urgentisteList1.setCategorieUrg(urgentiste.getCategorieUrg());
                urgentisteList1.setCniUrg(urgentiste.getCniUrg());
                urgentisteList1.setGenreUrg(urgentiste.getGenreUrg());
                urgentisteList1.setMatriculeUrg(urgentiste.getMatriculeUrg());
                urgentisteList1.setMpUrgentiste(urgentiste.getMpUrgentiste());
                urgentisteList1.setNomUrg(urgentiste.getNomUrg());
                urgentisteList1.setPrenomUrg(urgentiste.getPrenomUrg());
                urgentisteList1.setTelephoneUrg(urgentiste.getTelephoneUrg());
               
                ufl.edit(urgentisteList1);
                valueAcces =1;
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Modifie avec succes", "Correctement effectue."));
            }
        }       
         if(valueAcces !=1){
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));
            } 
        
    }
    
    
    public void updateFireProfile () {
        int valueAcces = 0;
        setPompierList(ppfl.findAll());
  
        for (Pompier pompierList1 : getPompierList()) {
            if (pompier.getIdPompier() == pompierList1.getIdPompier()) {
                
              
               //S pompierList1.setCategorieUrg(urgentiste.getCategorieUrg());
                pompierList1.setCniPompier(pompier.getCniPompier());
                pompierList1.setGenrePompier(pompier.getGenrePompier());
                pompierList1.setMatriculePompier(pompier.getMatriculePompier());
                pompierList1.setMpPompier(pompier.getMpPompier());
                pompierList1.setNomPompier(pompier.getNomPompier());
                pompierList1.setPrenomPompier(pompier.getPrenomPompier());
                pompierList1.setTelephonePompier(pompier.getTelephonePompier());
                pompierList1.setAdressePompier(pompier.getAdressePompier());
               
                ppfl.edit(pompierList1);
                valueAcces =1;
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Modifie avec succes", "Correctement effectue."));
            }
        }       
         if(valueAcces !=1){
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));
            } 
        
    }
//--------------------------------------------------------------------------------------------------------------------------
//*******************************List Methods*****************************
    
    // RÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©cupÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©rer un patient 
     public Patient listPatients() {
         
         Patient patientFound = new Patient();
        
        setListPatients(pfl.findAll());
          for(int i=0; i<getListPatients().size();i++)
        {
            
            if((patient.getCniPatient().equals(getListPatients().get(i).getCniPatient())))
            {
                patientFound = getListPatients().get(i);
                
                return patientFound;
            }
        }
     return null;
        
    }
     
   public  List<ForumHealthcare> listSubject()
   {
       return listSujetForum;
   
   }
    //RÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©cupÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©rer les antÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©cÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©dents mÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©dicaux du patient 
     public List<Antecedent> listPatientAntecedents() {
         List<Antecedent> antecedentFound = new ArrayList<>();
        
        listAntecedents = antecedentfl.findAll();
          for(int i=0; i<listAntecedents.size();i++)
        {
            
            if((patient.getCniPatient().equals(listAntecedents.get(i).getMatPatient())))
            {
                antecedentFound.add(listAntecedents.get(i));
            }
        }
     return antecedentFound;
        
    }
     
     public List<Biometrie> listPatientBiometrie() {
         List<Biometrie> biometrieFound = new ArrayList<>();
        
        listBiometrie = biometriefl.findAll();
          for(int i=0; i<listBiometrie.size();i++)
        {
            
            if((patient.getCniPatient().equals(listBiometrie.get(i).getCniPatientBio())))
            {
                biometrieFound.add(listBiometrie.get(i));
            }
        }
     return biometrieFound;
        
    }
    
     
     public List<Traitement> listPatientTraitement() {
         
         List<Traitement> traitementFound = new ArrayList<>();
        
        listTraitement = traitementfl.findAllInverse();
          for(int i=0; i<listTraitement.size();i++)
        {
            
            if((matriculePatient.equals(listTraitement.get(i).getCniPatTraite())))
            {
                traitementFound.add(listTraitement.get(i));
            }
        }
     return traitementFound;
        
    } 
    
     public List<Consultation> listPatientConsultation() {
         
         List<Consultation> consultationFound = new ArrayList<>();
        
        listConsultations = consultationfl.findAllInverse();
          for(int i=0; i<listConsultations.size();i++)
        {
            
            if((matriculePatient.equals(listConsultations.get(i).getCniPatient())))
            {
                consultationFound.add(listConsultations.get(i));
            }
        }
     return consultationFound;
        
    }  
     
    public List<Consultation> checkPatientConsultation() {
         
         List<Consultation> consultationFound = new ArrayList<>();
        
        listConsultations = consultationfl.findAllInverse();
        for (Consultation listConsultation : listConsultations) {
            if (cniPatientToConsult.equals(listConsultation.getCniPatient())) {
                consultationFound.add(listConsultation);
            }
        }
       
     return consultationFound;
        
    }  
    
    
    public List<Antecedent> checkPatientAntecedent() {
        
         List<Antecedent> antecedentFound = new ArrayList<>();
        
        listAntecedents = antecedentfl.findAll();
        for (Antecedent listAntecedent : listAntecedents) {
            if (patientToConsult.getCniPatient().equals(listAntecedent.getMatPatient())) {
                antecedentFound.add(listAntecedent);
            }
        }
     return antecedentFound;
        
    }
    
    public List<Planification> checkPatientPlanification() {
         List<Planification> plansFound = new ArrayList<>();
        
        listPlanifications = planfl.findAllInverse();
        
          for(int i=0; i<listPlanifications.size();i++)
        {
            
            if((patientToConsult.getCniPatient().equals(listVaccins.get(i).getCniPatient())))
            {
                plansFound.add(listPlanifications.get(i));
            }
        }
     return plansFound;
        
    }
    
    public List<Traitement> checkPatientTraitement() {
        
        List<Traitement> traitementFound = new ArrayList<>();
        
        listTraitement = traitementfl.findAllInverse();
        for (Traitement listTraitement1 : listTraitement) {
            if (patientToConsult.getCniPatient().equals(listTraitement1.getCniPatTraite())) {
                traitementFound.add(listTraitement1);
            }
        }
     return traitementFound;
        
        
    }
    
    public List<Ordonnance> listPatientOrdonnance() {
         
         List<Ordonnance> ordonnanceFound = new ArrayList<>();
        
        listOrdonnances = ordonnancefl.findAllInverse();
          for(int i=0; i<listOrdonnances.size();i++)
        {
            
            if((matriculePatient.equals(listOrdonnances.get(i).getMatriculePat())))
            {
                ordonnanceFound.add(listOrdonnances.get(i));
            }
        }
     return ordonnanceFound;
        
    }  
    
     public List<Ordonnance> checkPatientOrdonnance() {
         
         List<Ordonnance> ordonnanceFound = new ArrayList<>();
        
        listOrdonnances = ordonnancefl.findAllInverse();
        for (Ordonnance listOrdonnance : listOrdonnances) {
            if (cniPatientToConsult.equals(listOrdonnance.getMatriculePat())) {
                ordonnanceFound.add(listOrdonnance);
            }
        }
     return ordonnanceFound;
        
    }  
     
    public List<Courrier> listPatientCourrier() {
         
         List<Courrier> courriersFound = new ArrayList<>();
        
        listCourriers = courrierfl.findAllInverse();
          for(int i=0; i<listCourriers.size();i++)
        {
            
            if((matriculePatient.equals(listCourriers.get(i).getMatPatCour())))
            {
                courriersFound.add(listCourriers.get(i));
            }
        }
     return courriersFound;
        
    } 
    
    public List<Courrier> checkPatientCourrier() {
         
         List<Courrier> courriersFound = new ArrayList<>();
        
        listCourriers = courrierfl.findAllInverse();
        for (Courrier listCourrier : listCourriers) {
            if (cniPatientToConsult.equals(listCourrier.getMatPatCour())) {
                courriersFound.add(listCourrier);
            }
        }
     return courriersFound;
        
    } 
      
    public List<Examen> listPatientExamens() {
         
         List<Examen> examensFound = new ArrayList<>();
        
        listExamens = examfl.findAllInverse();
          for(int i=0; i<listExamens.size();i++)
        {
            
            if((matriculePatient.equals(listExamens.get(i).getCniPatExam())))
            {
                examensFound.add(listExamens.get(i));
            }
        }
     return examensFound;
    } 
    
    public List<Examen> checkPatientExamens() {
         
         List<Examen> examensFound = new ArrayList<>();
        
        listExamens = examfl.findAllInverse();
        for (Examen listExamen : listExamens) {
            if (cniPatientToConsult.equals(listExamen.getCniPatExam())) {
                examensFound.add(listExamen);
            }
        }
     return examensFound;
    } 
    
    public List<ConseilHealth> checkPatientExamenConseil() {
         String consultationAdvice = patient.getCniPatient();
         String conseilMotif;
         List<ConseilHealth> examenConseilFound = new ArrayList<>();
        
        listConseilExamen = conseilHealth_fl.findAllInverse();
        for (ConseilHealth listExamenConseil : listConseilExamen) {
            conseilMotif = listExamenConseil.getMotifConsultConseil();
            
            if ((conseilMotif == null)
            && (consultationAdvice.equals(listExamenConseil.getCniPatientConseil()))) {
                examenConseilFound.add( listExamenConseil);
            }
        }
     return examenConseilFound;
    } 
    
    public List<ConseilHealth> checkPatientConsultConseil() {
        String consultationAdvice = patient.getCniPatient();
        String ConseilMotif;
        List<ConseilHealth> consultationConseilFound = new ArrayList<>();
        System.out.println("cni du patient:"+patient.getCniPatient());
        
        listConseilConsult = conseilHealth_fl.findAllInverse();
        System.out.println("cni de la liste:" +listConseilConsult.get(1).getCniPatientConseil());
        for(int i=0; i< listConseilConsult.size(); i++) {
            
              ConseilMotif = listConseilConsult.get(i).getMotifConsultConseil();
                if((consultationAdvice.equals(listConseilConsult.get(i).getCniPatientConseil()))
                  && (ConseilMotif != null)) {
                   System.out.println(ConseilMotif );
                 consultationConseilFound.add( listConseilConsult.get(i)); 
            }
        }
      
     return consultationConseilFound;
    } 
        
    public List<Vaccination> listPatientVaccins() {
         
         List<Vaccination> vaccinsFound = new ArrayList<>();
        
        listVaccins = vaccinfl.findAllInverse();
          for(int i=0; i<listVaccins.size();i++)
        {
            
            if((matriculePatient.equals(listVaccins.get(i).getCniPatient())))
            {
                vaccinsFound.add(listVaccins.get(i));
            }
        }
     return vaccinsFound;
    } 
    
    public List<Vaccination> checkPatientVaccins() {
         
         List<Vaccination> vaccinsFound = new ArrayList<>();
        
        listVaccins = vaccinfl.findAllInverse();
        for (Vaccination listVaccin : listVaccins) {
            if (cniPatientToConsult.equals(listVaccin.getCniPatient())) {
                vaccinsFound.add(listVaccin);
            }
        }
     return vaccinsFound;
    } 
         
    public List<Planification> listPatientPlanification() {
         
         List<Planification> plansFound = new ArrayList<>();
        
        listPlanifications = planfl.findAllInverse();
        
          for(int i=0; i<listPlanifications.size();i++)
        {
            
            if((matriculePatient.equals(listVaccins.get(i).getCniPatient())))
            {
                plansFound.add(listPlanifications.get(i));
            }
        }
     return plansFound;
    } 
         
    public String patientProfile () {
        
        List<Patient> listOfPatient;
        listOfPatient = pfl.findAll();
        
        for (Patient listOfPatient1 : listOfPatient) {
            if (cniPatientToConsult.equals(listOfPatient1.getCniPatient())) {
                System.out.println(listOfPatient1.getCniPatient());
                patientToConsult = listOfPatient1;
                return "showPatientProfile";
            }
            
        }
       
          FacesContext context = FacesContext.getCurrentInstance(); 
           context.addMessage(null, new FacesMessage("Aucun patient trouve", "Erreur!!!.")); 
        return null;
    }
    
       public String patientSocialProfile() {
        
        List<Patient> listOfPatient;
        listOfPatient = pfl.findAll();
        
        for (Patient listOfPatient1 : listOfPatient) {
            if (cniSocialPatient.equals(listOfPatient1.getCniPatient())) {
                System.out.println(listOfPatient1.getCniPatient());
                patientToConsult = listOfPatient1;
                return "/FR/SocialSecurity/chooseSecurityType.xhtml";
            }
            
        }
         FacesContext context = FacesContext.getCurrentInstance(); 
           context.addMessage(null, new FacesMessage("Aucun patient trouve", "Erreur!!!.")); 
        return null;
  }
       
        public void destroyWorld() {
        addMessage("Cette fonctionnalite sera disponible ulterieurement", "Veuillez attendre la version finale.");
    }
    
     public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
       public String showPrivateCompany() {
           
           return "/FR/SocialSecurity/privateCompanyInterface.xhtml";
       }
        
       public String showPublicCompany () {
           
           return "/FR/SocialSecurity/PublicCompany/chooseCompanyInterface.xhtml";
       }
       
       public String showDoctorPublicCompany() {
         
           return "/FR/SocialSecurity/PublicCompany/publicCompanyInterface.xhtml";
       }
    
       public String showHomeless () {
           
          return "/FR/SocialSecurity/homelessInterface.xhtml"; 
       }
    
    public String patientProfileForNurse () {
        
        List<Patient> listOfPatient;
        listOfPatient = pfl.findAll();
        
        for (Patient listOfPatient1 : listOfPatient) {
            if (cniPatientToConsult.equals(listOfPatient1.getCniPatient())) {
                System.out.println(listOfPatient1.getCniPatient());
                patientToConsult = listOfPatient1;
                return "/FR/Nurse/patientProfile.xhtml";
            }
            
        }
        
          FacesContext context = FacesContext.getCurrentInstance(); 
           context.addMessage(null, new FacesMessage("Aucun patient trouve", "Erreur!!!.")); 
        return null;
    }
       
    
     public String patientProfileForFire () {
        
        List<Patient> listOfPatient;
        listOfPatient = pfl.findAll();
        
        for (Patient listOfPatient1 : listOfPatient) {
            if (cniPatientToConsult.equals(listOfPatient1.getCniPatient())) {
                System.out.println(listOfPatient1.getCniPatient());
                patientToConsult = listOfPatient1;
                return "/FR/FireFigther/patientProfile.xhtml";
            }
            
        }
        
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun patient trouve", "Remplir tous les champs."));
 return null;
    }
       
          

    
            
          

    
     
    //************************************Adds Methods*****************************************
         
          public String addUrgentiste(){
        
     
        System.out.println("la fonction a ete traversÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©e.");
         if(!urgentiste.getMatriculeUrg().equals("") && !urgentiste.getMpUrgentiste().equals("")){
           ufl.create(urgentiste);
           FacesContext context = FacesContext.getCurrentInstance(); 
           context.addMessage(null, new FacesMessage("Inscription RÃƒÂ©ussie", "SuccÃƒÂ¨s"));  
           urgentiste = new Urgentiste();
           
           return "/FR/Nurse/authenticateNurse.xhtml";
       }else{
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("Ajout reussi", "Correctement effectue."));              
       }    
         return "";
    }
    
    public String addPatient(){
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy ");
        Date today = getDateConvertible();        
        String reportDate = df.format(today);
        patient.setDateNaissPatient(reportDate);
        patient.setStatus("ON");
        setDossierMedical(patient);
         if(!patient.getCniPatient().equals("")&& !patient.getMpPatient().equals("")){
         dm_fl.create(d_medical);
        pfl.create(patient);
        patient = new Patient();
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("Inscription Reussie", "Correctement effectue.")); 
        
        return "/FR/Patient/authenticatePatient.xhtml";
       
         }else{
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));
   
       } 
         return "";
    }
    
     public String addPatientByDoctor(){
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy ");
        Date today = getDateConvertible();        
        String reportDate = df.format(today);
        patientByDoctor.setDateNaissPatient(reportDate);
        patientByDoctor.setStatus("ON");
        setDossierMedicalByDoctor(patientByDoctor);
        if(patientByDoctor.getNomPatient()==null){
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));
    }else{
        dm_fl.create(d_medical);
        pfl.create(patientByDoctor);

        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("Ajout reussi", "Correctement effectue."));    

        patientByDoctor = new Patient();
        
        return "/FR/Doctor/welcomeDoctorPage.xhtml";
       } 
        
        return "";
    }
    
    public void setDossierMedical(Patient patient) {
        d_medical.setNom(patient.getNomPatient());
        d_medical.setPrenom(patient.getPrenomPatient());
        d_medical.setDateNaiss(patient.getAdressePatient());
        d_medical.setAdresse(patient.getAdressePatient());
        d_medical.setGenre(patient.getGenrePatient());
        d_medical.setMatricule(patient.getCniPatient());
        d_medical.setStatus("ON");
        
    }
    
     public void setDossierMedicalByDoctor(Patient patient) {
        d_medical.setNom(patient.getNomPatient());
        d_medical.setPrenom(patient.getPrenomPatient());
        d_medical.setDateNaiss(patient.getAdressePatient());
        d_medical.setLieuNaiss(patient.getLieuNaissPat());
        d_medical.setCorrespondant(patient.getCorrespondantPat());
        d_medical.setProfPat(patient.getProfPatient());
        d_medical.setCaissPat(patient.getCaissePat());
        d_medical.setEmail(patient.getEmailPat());
        d_medical.setSituationFamPat(patient.getSituationFamPat());
        d_medical.setAdresse(patient.getAdressePatient());
        d_medical.setGenre(patient.getGenrePatient());
        d_medical.setMatricule(patient.getCniPatient());
        d_medical.setStatus("ON");
        
    }
    
    public String addPompier() {
        
        
        System.out.println("la fonction a ete traversÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©e.");
         if(!pompier.getMatriculePompier().equals("")&&!pompier.getMpPompier().equals("")){
           getPpfl().create(pompier);
           pompier = new Pompier();
           FacesContext context = FacesContext.getCurrentInstance(); 
           context.addMessage(null, new FacesMessage("Inscription RÃƒÂ©ussie", "Succes"));    
           
           return "/FR/FireFigther/authenticateFireFigther.xhtml";
       }else{
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));
    }  
        return "";
    }
    
    public void sendMessage() {
        getContact_service_fl().create(conactMsg);
        conactMsg = new ContactService();
    }
           
    
    public String addDocteur() {
        
        
        
        System.out.println("la fonction a ete traversÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â©e.");
         if(!docteur.getMatriculeDocteur().equals("")&& !docteur.getMpDocteur().equals("")){
           dfl.create(docteur);
           FacesContext context = FacesContext.getCurrentInstance(); 
           context.addMessage(null, new FacesMessage("Inscription reussie", "Bienvenue")); 
           
           docteur = new Docteur();
           
           return "/FR/Doctor/authenticateDoctor.xhtml";
       }else{
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));
 }  
        return "";
    }
         
 public String addPublication ()
    {
        System.out.println("je suis dans dans la methode.");
        if(!subject.getCategorieSujet().equals("")){
            System.out.println("Dans la methode d'ajout de la publication"+patient.getIdPatient());
           subject.setIdCreator(patient.getIdPatient().toString());
           System.out.println("id auteur :"+subject.getIdCreator());
           DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
           Date today = dateConvertiblePublication;        
           String reportDate = df.format(today);
	   subject.setDateCreationSujet(reportDate);
           System.out.println("date de creation du sujet"+subject.getDateCreationSujet());
           forum_health_fl.create(subject);
           
           subject = new ForumHealthcare();
           FacesContext context = FacesContext.getCurrentInstance(); 
           context.addMessage(null, new FacesMessage("Sujet Cree", "Succes!!!.")); 
           
           
           return "/FR/Patient/sujetsForum.xhtml";
    
       }else{
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));
    }  
       return "";
    }
 
 public String addCommentDiscussion() {
     
     System.out.println("dans la fonction d'ajout de commentaires");
     DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
           Date today = dateConvertiblePublication;      
           String reportDate = df.format(today);
	   comment.setDateComment(reportDate);
           comment.setSujetComment(subjectChoosed);
           comment.setIdUser(docteur.getMatriculeDocteur());
           
           
           filDiscuss.setSujet(subjectChoosed);
           filDiscuss.setContents(comment.getContents());
           filDiscuss.setStatus("on");
           filDiscuss.setDatePublication(reportDate);
           filDiscuss.setIdUser(docteur.getMatriculeDocteur());
           filDiscuss.setCategoryComment(themeForum);
           filDiscuss.setIdSujetForum(idSujetForum);

           if (comment.getContents().equals(""))
           {
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Remplissez le champ avant de valider", "Remplir tous les champs."));
   
           } else {
              
               commentfl.create(comment);
               fil_discussion_fl.create(filDiscuss);
               
                FacesContext context = FacesContext.getCurrentInstance(); 
               context.addMessage(null, new FacesMessage("Ajoutez avec succes!", "Correctement effectue."));              
       
               filDiscuss = new FilDiscussion();
               comment = new Commentaire();
               
               return "/FR/Doctor/listSubjectForum.xhtml";
           }
      return "";
 }
 
  public String addCommentDiscussionPatient() {
     
     System.out.println("dans la fonction d'ajout de commentaires");
     DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
           Date today = dateConvertiblePublication;      
           String reportDate = df.format(today);
	   comment.setDateComment(reportDate);
           comment.setSujetComment(subjectChoosed);
           comment.setIdUser(patient.getCniPatient());
           
           
           filDiscuss.setSujet(subjectChoosed);
           filDiscuss.setContents(comment.getContents());
           filDiscuss.setStatus("on");
           filDiscuss.setDatePublication(reportDate);
           filDiscuss.setIdUser(patient.getCniPatient());
           filDiscuss.setCategoryComment(themeForum);
           filDiscuss.setIdSujetForum(idSujetForum);

           if (comment.getContents().equals(""))
           {
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Remplissez le champ avant de valider", "Remplir tous les champs."));
   
           } else {
               
                
               commentfl.create(comment);
               fil_discussion_fl.create(filDiscuss);
               
               FacesContext context = FacesContext.getCurrentInstance(); 
               context.addMessage(null, new FacesMessage("Ajoutez avec succes!", "Correctement effectue."));              
       
               filDiscuss = new FilDiscussion();
               comment = new Commentaire();
              
            return "/FR/Patient/sujetsForum.xhtml";
           }
        return "";   
 }
 public void addConsultation () {
     
        DateFormat df_Consultation = new SimpleDateFormat("dd/MM/yyyy ");
        Date today = getDateConvertibleConsult();        
        String reportDateConsultation = df_Consultation.format(today);
        consultation.setDateConsult(reportDateConsultation);
        consultation.setCniPatient(patientToConsult.getCniPatient());
        consultation.setMatMedConsult(docteur.getMatriculeDocteur());
        if (!consultation.getObservConsult().equals("")) {
         
        consultationfl.create(consultation);
        consultRecap.add(consultation);
        consultation = new Consultation();
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("Enregistre avec succes", "Correctement effectue."));              
     
      
     }
        else{
             
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));
    }
 }
 
  public void addConseil () {
        DateFormat df_Consultation = new SimpleDateFormat("dd/MM/yyyy ");
        Date today = new Date();
        String reportDateConseilConsult = df_Consultation.format(today);
        conseil.setDatePublication(reportDateConseilConsult);
        conseil.setNomDocteur(docteur.getNomDocteur());
        
        conseil.setActeConsultConseil(selectConsultation.getActeConsult());
        conseil.setCniPatientConseil(selectConsultation.getCniPatient());
        conseil.setDateConsultConseil(selectConsultation.getDateConsult());
        conseil.setMatMedConseil(selectConsultation.getMatMedConsult());
        conseil.setObservConsultConseil(selectConsultation.getMotifConsult());
        conseil.setMotifConsultConseil(selectConsultation.getMotifConsult());
        conseil.setPoidsConsultConseil(selectConsultation.getPoidsConsult());
        conseil.setTensionConsultConseil(selectConsultation.getTensionConsult());
        conseil.setPoulConsultConseil(selectConsultation.getPoulsConsult());
        if (conseil.getContenuConseil().equalsIgnoreCase("")) {
         
                   
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));
   
    
     }
        else{
          conseilHealth_fl.create(conseil);
         FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("Enregistre avec succes", "Correctement effectue."));              
     
        conseil = new ConseilHealth();
        }
       }
  
  public void addConseilExam () {
        DateFormat df_Consultation = new SimpleDateFormat("dd/MM/yyyy ");
        Date today = new Date();
        String reportDateConseilExam = df_Consultation.format(today);
        conseil.setDatePublication(reportDateConseilExam);
        conseil.setNomDocteur(docteur.getNomDocteur());
        
        conseil.setActeConsultConseil("");
        conseil.setCniPatientConseil(selectedExam.getCniPatExam());
        conseil.setDateConsultConseil(selectedExam.getDateExam());
        conseil.setMatMedConseil(selectedExam.getMatMedExam());
        conseil.setObservConsultConseil(selectedExam.getContenuExam());
        conseil.setMotifConsultConseil("");
        conseil.setPoidsConsultConseil("");
        conseil.setTensionConsultConseil("");
        conseil.setPoulConsultConseil("");
        if (conseil.getContenuConseil().equalsIgnoreCase("")) {
         
                   
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));
   
    
     }
        else{
          conseilHealth_fl.create(conseil);
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("Enregistre avec succes", "Correctement effectue."));              
     
        conseil = new ConseilHealth();
        }
       }
 
 public void  addOrdonnance () {
        
     System.out.println(ordonnace.getPrescriptionOrdo());
        DateFormat df_Consultation = new SimpleDateFormat("dd/MM/yyyy ");
        Date today = getDateConvertibleOrdo();
        String reportDateOrdonnance = df_Consultation.format(today);
        ordonnace.setDateOrdo(reportDateOrdonnance);
        ordonnace.setMatriculePat(patientToConsult.getCniPatient());
        ordonnace.setMatriculeMed(docteur.getMatriculeDocteur());
        if (ordonnace.getCategorieOrdo()!=null) {
        ordonnancefl.create(ordonnace);
        System.out.println("ca a traverse le create");
        ordoRecap.add(ordonnace);
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("Enregistre avec succes", "Correctement effectuÃƒÆ’Ã‚Â©."));              
     
        ordonnace = new Ordonnance();
     }
        else{
             
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! VÃƒÆ’Ã‚Â©rifiez vos informations", "Remplir tous les champs."));
}
 }
 
public void  addCourrier () {
        
   
        DateFormat df_Consultation = new SimpleDateFormat("dd/MM/yyyy ");
        Date today = getDateConvertibleOrdo();
        String reportDateOrdonnance = df_Consultation.format(today);
        courrier.setDateCourrier(reportDateOrdonnance);
        courrier.setMatPatCour(patientToConsult.getCniPatient());
        courrier.setMatMedCour(docteur.getMatriculeDocteur());
        if ((courrier.getContenuCour().equalsIgnoreCase("")) || 
                (courrier.getCategoCourrier().equalsIgnoreCase(""))||
                (courrier.getDestinCour().equalsIgnoreCase(""))) {
            
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));

     }
        else{
 
        courrierfl.create(courrier);
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("Enregistre avec succes", "Correctement effectue."));              
        courrier = new Courrier();
        }
 }
 
public void  addVaccination () {
        
   
        DateFormat df_vaccin = new SimpleDateFormat("dd/MM/yyyy ");
        Date today = getDateconvertibleVaccin();
        String reportDateVaccin = df_vaccin .format(today);
        
        DateFormat df_rappel_vaccin = new SimpleDateFormat("dd/MM/yyyy ");
        Date todayRappel = getDateConvertibleRappelVaccin();
        String reportDateVaccinRappel = df_rappel_vaccin.format(todayRappel);
        
        vaccin.setDateVacc(reportDateVaccin);
        vaccin.setRappelVacc(reportDateVaccinRappel);
        vaccin.setCniPatient(patientToConsult.getCniPatient());
        vaccin.setMatMedVacc(docteur.getMatriculeDocteur());
        if ((vaccin.getNomVaccin().equalsIgnoreCase("")) || 
                (vaccin.getDateVacc().equalsIgnoreCase(""))) {
            
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));

     }
        else{
 
        vaccinfl.create(vaccin);
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("Enregistre avec succes", "Correctement effectue."));              
        vaccin = new Vaccination();
        }
 }
 
public void  addExamen () {
        
   
        DateFormat df_Exam = new SimpleDateFormat("dd/MM/yyyy ");
        Date today = getDateConvertibleExam();
        String reportDateExam = df_Exam.format(today);
        examen.setDateExam(reportDateExam);
        examen.setCniPatExam(patientToConsult.getCniPatient());
        examen.setMatMedExam(docteur.getMatriculeDocteur());
        if ((examen.getContenuExam().equalsIgnoreCase("")) || (examen.getDateExam().equalsIgnoreCase(""))){
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur ! Verifiez vos informations", "Remplir tous les champs."));

     }
        else{
 
       examfl.create(examen);
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("Enregistre avec succes", "Correctement effectue."));              
        examen = new Examen();
        }
        
 }

public void handleFileUploadSms(FileUploadEvent event) {
   
        FacesMessage message = new FacesMessage("Succes", event.getFile().getFileName() + " est charge.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        String nomFichier = event.getFile().getFileName();
        lienTelechargementDocConsultation = lienTelechargementDocConsultation+nomFichier;
        messageSms = lienTelechargementDocConsultation;
        
        try {
            copyFileSms(nomFichier, event.getFile().getInputstream());
        } catch (IOException e) {
        }
        
     
    }


 
 public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succes", event.getFile().getFileName() + " est charge.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        nomFichierCharge = event.getFile().getFileName();
        lienFichierGenere = "http://172.16.72.195:8080/healthCare/docEmail/"+nomFichierCharge;
        
        System.out.println("lien fichiergenere:"+lienFichierGenere);
        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
        }
    }
 
 public void copyFileSms(String fileName, InputStream in) {
           try {
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(getLienFichierChargeSms() + fileName));
             
                int read = 0;
                byte[] bytes = new byte[1024];
             
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
             
                in.close();
                out.flush();
                out.close();
             
                System.out.println("New file created!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
 
 public void copyFile(String fileName, InputStream in) {
           try {
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(lienFichierCharge + fileName));
             
                int read = 0;
                byte[] bytes = new byte[1024];
             
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
             
                in.close();
                out.flush();
                out.close();
             
                System.out.println("New file created!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
 
 public void sendEmail () throws EmailException, MalformedURLException {
     
   EmailAttachment attachment = new EmailAttachment();
  attachment.setURL(new URL(lienFichierGenere));
  attachment.setDisposition(EmailAttachment.ATTACHMENT);
  attachment.setDescription(nomFichierCharge);
  attachment.setName(nomFichierCharge);

  
MultiPartEmail email = new MultiPartEmail();

email.setHostName("smtp.googlemail.com");
email.setSmtpPort(465);
email.setAuthenticator(new DefaultAuthenticator("camerounhealthcare@gmail.com", "Camtel-1"));
email.setSSLOnConnect(true);
email.setFrom("camerounhealthcare@gmail.com");
email.setSubject(emailHealth.getSujetMsg());
email.setMsg(emailHealth.getMessage());
email.addTo(emailHealth.getDestMsg());

 
  // add the attachment
  email.attach(attachment);

email.send();
          FacesContext context = FacesContext.getCurrentInstance(); 
           context.addMessage(null, new FacesMessage("Votre email a ete envoye avec succes", "Envoi reussi.")); 
emailHealth = new EmailHealthcare();
    }
 
 public void sendSms () throws IOException   {
    
    
    String USER_AGENT = "Mozilla/5.0";
    
     //url camtel : "http://192.168.144.99/sendsms8.php?text="+messageSms+"&to="+numPatient;
     //String o_sUrl = "http://zagsms.net/lang_fr/apicmr.php?action="+"envoismsun&id="+"237675916748&msg="+messageSms+"&pwd="+"testsms&to="+numPatient+"&sender="+"237675916748&codest="+"237";
     //Url Zag
      System.out.println(numPatient);
     String o_sUrl = "http://zagsms.net/lang_fr/apicmr.php?";
   URL obj = new URL(o_sUrl);
		HttpURLConnection con =  (java.net.HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "action=envoismsun&id=237675916748&msg="+messageSms+"&pwd=testsms&to="+numPatient+"&sender=237675916748&codest=237";
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + o_sUrl);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
                
                if(response.toString().equals("")) {
                    numPatient = "";
                    messageSms = "";
                     FacesContext context = FacesContext.getCurrentInstance(); 
                context.addMessage(null, new FacesMessage("Votre sms a ete envoye", "Envoi effectue."));  
		
                } else {
                    
                 //   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur pendant la processus", "Remplir tous les champs."));

                }
                    
                
               
		//print result
		System.out.println(response.toString());

	}
 
 
  public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
   
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
 
     // ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = "C:\\www\\healthCare\\healthCare\\src\\main\\webapp\\images\\banner.png";
        pdf.add(Image.getInstance(logo));


    
    /*    FileWriter writer = null;
String texte = docteur.getNomDocteur();
try{
     writer = new FileWriter(pdf, true);
     writer.write(texte,0,texte.length());
}catch(IOException ex){
    ex.printStackTrace();
}finally{
  if(writer != null){
     writer.close();
  }
}*/
    }
  
    public void postProcessPDF(Object document) {
      
      String sourceFile= "C:\\Users\\herma\\Downloads\\Documents\\"; 
      String fileName = patientToConsult.getNomPatient()+dateFormatteConsult+".pdf";
      
        File linkFile = new File(sourceFile+fileName);
        File destination = new File(linkToRepConsultation+patientToConsult.getCniPatient()+".pdf");
        System.out.print("on a traversÃƒÂ© la mÃƒÂ©thode de renommage");
        linkFile.renameTo(destination);
    }

  
    /**
     * @return the ufl
     */
    public UrgentisteFacadeLocal getUfl() {
        return ufl;
    }

    /**
     * @param ufl the ufl to set
     */
    public void setUfl(UrgentisteFacadeLocal ufl) {
        this.ufl = ufl;
    }

    /**
     * @return the urgentiste
     */
    public Urgentiste getUrgentiste() {
        return urgentiste;
    }

    /**
     * @param urgentiste the urgentiste to set
     */
    public void setUrgentiste(Urgentiste urgentiste) {
        this.urgentiste = urgentiste;
    }

    /**
     * @return the pfl
     */
    public PatientFacadeLocal getPfl() {
        return pfl;
    }

    /**
     * @param pfl the pfl to set
     */
    public void setPfl(PatientFacadeLocal pfl) {
        this.pfl = pfl;
    }

    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return the pompier
     */
    public Pompier getPompier() {
        return pompier;
    }

    /**
     * @param pompier the pompier to set
     */
    public void setPompier(Pompier pompier) {
        this.pompier = pompier;
    }

    /**
     * @return the ppfl
     */
    public PompierFacadeLocal getPpfl() {
        return ppfl;
    }

    /**
     * @param ppfl the ppfl to set
     */
    public void setPpfl(PompierFacadeLocal ppfl) {
        this.ppfl = ppfl;
    }

    /**
     * @return the dfl
     */
    public DocteurFacadeLocal getDfl() {
        return dfl;
    }

    /**
     * @param dfl the dfl to set
     */
    public void setDfl(DocteurFacadeLocal dfl) {
        this.dfl = dfl;
    }

    /**
     * @return the docteur
     */
    public Docteur getDocteur() {
        return docteur;
    }

    /**
     * @param docteur the docteur to set
     */
    public void setDocteur(Docteur docteur) {
        this.docteur = docteur;
    }

    /**
     * @return the file
     */
    public UploadedFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }


    /**
     * @return the biometriefl
     */
    public BiometrieFacadeLocal getBiometriefl() {
        return biometriefl;
    }

    /**
     * @param biometriefl the biometriefl to set
     */
    public void setBiometriefl(BiometrieFacadeLocal biometriefl) {
        this.biometriefl = biometriefl;
    }

    /**
     * @return the traitementfl
     */
    public TraitementFacadeLocal getTraitementfl() {
        return traitementfl;
    }

    /**
     * @param traitementfl the traitementfl to set
     */
    public void setTraitementfl(TraitementFacadeLocal traitementfl) {
        this.traitementfl = traitementfl;
    }

    /**
     * @return the biometrie
     */
    public Biometrie getBiometrie() {
        return biometrie;
    }

    /**
     * @param biometrie the biometrie to set
     */
    public void setBiometrie(Biometrie biometrie) {
        this.biometrie = biometrie;
    }

    /**
     * @return the traitement
     */
    public Traitement getTraitement() {
        return traitement;
    }

    /**
     * @param traitement the traitement to set
     */
    public void setTraitement(Traitement traitement) {
        this.traitement = traitement;
    }

    /**
     * @return the dateConvertibleTraitement
     */
    public Date getDateConvertibleTraitement() {
        return dateConvertibleTraitement;
    }

    /**
     * @param dateConvertibleTraitement the dateConvertibleTraitement to set
     */
    public void setDateConvertibleTraitement(Date dateConvertibleTraitement) {
        this.dateConvertibleTraitement = dateConvertibleTraitement;
    }

    /**
     * @return the listBiometrie
     */
    public List<Biometrie> getListBiometrie() {
        return listBiometrie;
    }

    /**
     * @param listBiometrie the listBiometrie to set
     */
    public void setListBiometrie(List<Biometrie> listBiometrie) {
        this.listBiometrie = listBiometrie;
    }

    /**
     * @return the listTraitement
     */
    public List<Traitement> getListTraitement() {
        return listTraitement;
    }

    /**
     * @param listTraitement the listTraitement to set
     */
    public void setListTraitement(List<Traitement> listTraitement) {
        this.listTraitement = listTraitement;
    }

    /**
     * @return the listUrgentiste
     */
    public List<Urgentiste> getListUrgentiste() {
        return listUrgentiste;
    }

    /**
     * @param listUrgentiste the listUrgentiste to set
     */
    public void setListUrgentiste(List<Urgentiste> listUrgentiste) {
        this.listUrgentiste = listUrgentiste;
    }

    /**
     * @return the patients
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * @param patients the patients to set
     */
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    /**
     * @return the filteredPatient
     */
    public List<Patient> getFilteredPatient() {
        return filteredPatient;
    }

    /**
     * @param filteredPatient the filteredPatient to set
     */
    public void setFilteredPatient(List<Patient> filteredPatient) {
        this.filteredPatient = filteredPatient;
    }

    /**
     * @return the listAntecedents
     */
    public List<Antecedent> getListAntecedents() {
        return listAntecedents;
    }

    /**
     * @param listAntecedents the listAntecedents to set
     */
    public void setListAntecedents(List<Antecedent> listAntecedents) {
        this.listAntecedents = listAntecedents;
    }

    /**
     * @return the antecedentfl
     */
    public AntecedentFacadeLocal getAntecedentfl() {
        return antecedentfl;
    }

    /**
     * @param antecedentfl the antecedentfl to set
     */
    public void setAntecedentfl(AntecedentFacadeLocal antecedentfl) {
        this.antecedentfl = antecedentfl;
    }

    /**
     * @return the listConsultations
     */
    public List<Consultation> getListConsultations() {
        return listConsultations;
    }

    /**
     * @param listConsultations the listConsultations to set
     */
    public void setListConsultations(List<Consultation> listConsultations) {
        this.listConsultations = listConsultations;
    }

    /**
     * @return the consultationfl
     */
    public ConsultationFacadeLocal getConsultationfl() {
        return consultationfl;
    }

    /**
     * @param consultationfl the consultationfl to set
     */
    public void setConsultationfl(ConsultationFacadeLocal consultationfl) {
        this.consultationfl = consultationfl;
    }

    /**
     * @return the ordonnancefl
     */
    public OrdonnanceFacadeLocal getOrdonnancefl() {
        return ordonnancefl;
    }

    /**
     * @param ordonnancefl the ordonnancefl to set
     */
    public void setOrdonnancefl(OrdonnanceFacadeLocal ordonnancefl) {
        this.ordonnancefl = ordonnancefl;
    }

    /**
     * @return the consultation
     */
    public Consultation getConsultation() {
        return consultation;
    }

    /**
     * @param consultation the consultation to set
     */
    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    /**
     * @return the ordonnace
     */
    public Ordonnance getOrdonnace() {
        return ordonnace;
    }

    /**
     * @param ordonnace the ordonnace to set
     */
    public void setOrdonnace(Ordonnance ordonnace) {
        this.ordonnace = ordonnace;
    }

    /**
     * @return the courrierfl
     */
    public CourrierFacadeLocal getCourrierfl() {
        return courrierfl;
    }

    /**
     * @param courrierfl the courrierfl to set
     */
    public void setCourrierfl(CourrierFacadeLocal courrierfl) {
        this.courrierfl = courrierfl;
    }

    /**
     * @return the listCourriers
     */
    public List<Courrier> getListCourriers() {
        return listCourriers;
    }

    /**
     * @param listCourriers the listCourriers to set
     */
    public void setListCourriers(List<Courrier> listCourriers) {
        this.listCourriers = listCourriers;
    }

    /**
     * @return the vaccinfl
     */
    public VaccinationFacadeLocal getVaccinfl() {
        return vaccinfl;
    }

    /**
     * @param vaccinfl the vaccinfl to set
     */
    public void setVaccinfl(VaccinationFacadeLocal vaccinfl) {
        this.vaccinfl = vaccinfl;
    }

    /**
     * @return the planfl
     */
    public PlanificationFacadeLocal getPlanfl() {
        return planfl;
    }

    /**
     * @param planfl the planfl to set
     */
    public void setPlanfl(PlanificationFacadeLocal planfl) {
        this.planfl = planfl;
    }

    /**
     * @return the examfl
     */
    public ExamenFacadeLocal getExamfl() {
        return examfl;
    }

    /**
     * @param examfl the examfl to set
     */
    public void setExamfl(ExamenFacadeLocal examfl) {
        this.examfl = examfl;
    }

    /**
     * @return the courrier
     */
    public Courrier getCourrier() {
        return courrier;
    }

    /**
     * @param courrier the courrier to set
     */
    public void setCourrier(Courrier courrier) {
        this.courrier = courrier;
    }

    /**
     * @return the docList
     */
    public List<Docteur> getDocList() {
        return docList;
    }

    /**
     * @param docList the docList to set
     */
    public void setDocList(List<Docteur> docList) {
        this.docList = docList;
    }

    /**
     * @return the listPatients
     */
    public List<Patient> getListPatients() {
        return listPatients;
    }

    /**
     * @param listPatients the listPatients to set
     */
    public void setListPatients(List<Patient> listPatients) {
        this.listPatients = listPatients;
    }

    /**
     * @return the examen
     */
    public Examen getExamen() {
        return examen;
    }

    /**
     * @param examen the examen to set
     */
    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    /**
     * @return the vaccin
     */
    public Vaccination getVaccin() {
        return vaccin;
    }

    /**
     * @param vaccin the vaccin to set
     */
    public void setVaccin(Vaccination vaccin) {
        this.vaccin = vaccin;
    }

    /**
     * @return the planification
     */
    public Planification getPlanification() {
        return planification;
    }

    /**
     * @param planification the planification to set
     */
    public void setPlanification(Planification planification) {
        this.planification = planification;
    }

    /**
     * @return the listExamens
     */
    public List<Examen> getListExamens() {
        return listExamens;
    }

    /**
     * @param listExamens the listExamens to set
     */
    public void setListExamens(List<Examen> listExamens) {
        this.listExamens = listExamens;
    }

    /**
     * @return the listVaccins
     */
    public List<Vaccination> getListVaccins() {
        return listVaccins;
    }

    /**
     * @param listVaccins the listVaccins to set
     */
    public void setListVaccins(List<Vaccination> listVaccins) {
        this.listVaccins = listVaccins;
    }

    /**
     * @return the listPlanifications
     */
    public List<Planification> getListPlanifications() {
        return listPlanifications;
    }

    /**
     * @param listPlanifications the listPlanifications to set
     */
    public void setListPlanifications(List<Planification> listPlanifications) {
        this.listPlanifications = listPlanifications;
    }

    /**
     * @return the themeForum
     */
    public String getThemeForum() {
        return themeForum;
    }

    /**
     * @param themeForum the themeForum to set
     */
    public void setThemeForum(String themeForum) {
        this.themeForum = themeForum;
    }

    /**
     * @return the forum_health_fl
     */
    public ForumHealthcareFacadeLocal getForum_health_fl() {
        return forum_health_fl;
    }

    /**
     * @param forum_health_fl the forum_health_fl to set
     */
    public void setForum_health_fl(ForumHealthcareFacadeLocal forum_health_fl) {
        this.forum_health_fl = forum_health_fl;
    }

    /**
     * @return the commentfl
     */
    public CommentaireFacadeLocal getCommentfl() {
        return commentfl;
    }

    /**
     * @param commentfl the commentfl to set
     */
    public void setCommentfl(CommentaireFacadeLocal commentfl) {
        this.commentfl = commentfl;
    }

    /**
     * @return the fil_discussion_fl
     */
    public FilDiscussionFacadeLocal getFil_discussion_fl() {
        return fil_discussion_fl;
    }

    /**
     * @param fil_discussion_fl the fil_discussion_fl to set
     */
    public void setFil_discussion_fl(FilDiscussionFacadeLocal fil_discussion_fl) {
        this.fil_discussion_fl = fil_discussion_fl;
    }

    /**
     * @return the subject
     */
    public ForumHealthcare getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(ForumHealthcare subject) {
        this.subject = subject;
    }

    /**
     * @return the comment
     */
    public Commentaire getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(Commentaire comment) {
        this.comment = comment;
    }

    /**
     * @return the filDiscuss
     */
    public FilDiscussion getFilDiscuss() {
        return filDiscuss;
    }

    /**
     * @param filDiscuss the filDiscuss to set
     */
    public void setFilDiscuss(FilDiscussion filDiscuss) {
        this.filDiscuss = filDiscuss;
    }

    /**
     * @return the listSujetForum
     */
    public List<ForumHealthcare> getListSujetForum() {
        return listSujetForum;
    }

    /**
     * @param listSujetForum the listSujetForum to set
     */
    public void setListSujetForum(List<ForumHealthcare> listSujetForum) {
        this.listSujetForum = listSujetForum;
    }

    /**
     * @return the listDiscussions
     */
    public List<FilDiscussion> getListDiscussions() {
        return listDiscussions;
    }

    /**
     * @param listDiscussions the listDiscussions to set
     */
    public void setListDiscussions(List<FilDiscussion> listDiscussions) {
        this.listDiscussions = listDiscussions;
    }

    /**
     * @return the listComments
     */
    public List<Commentaire> getListComments() {
        return listComments;
    }

    /**
     * @param listComments the listComments to set
     */
    public void setListComments(List<Commentaire> listComments) {
        this.listComments = listComments;
    }

    /**
     * @return the conactMsg
     */
    public ContactService getConactMsg() {
        return conactMsg;
    }

    /**
     * @param conactMsg the conactMsg to set
     */
    public void setConactMsg(ContactService conactMsg) {
        this.conactMsg = conactMsg;
    }

    /**
     * @return the contact_service_fl
     */
    public ContactServiceFacadeLocal getContact_service_fl() {
        return contact_service_fl;
    }

    /**
     * @param contact_service_fl the contact_service_fl to set
     */
    public void setContact_service_fl(ContactServiceFacadeLocal contact_service_fl) {
        this.contact_service_fl = contact_service_fl;
    }

    /**
     * @return the d_medical
     */
    public DossierMedical getD_medical() {
        return d_medical;
    }

    /**
     * @param d_medical the d_medical to set
     */
    public void setD_medical(DossierMedical d_medical) {
        this.d_medical = d_medical;
    }

    /**
     * @return the patientToConsult
     */
    public Patient getPatientToConsult() {
        return patientToConsult;
    }

    /**
     * @param patientToConsult the patientToConsult to set
     */
    public void setPatientToConsult(Patient patientToConsult) {
        this.patientToConsult = patientToConsult;
    }

    /**
     * @return the cniPatientToConsult
     */
    public String getCniPatientToConsult() {
        return cniPatientToConsult;
    }

    /**
     * @param cniPatientToConsult the cniPatientToConsult to set
     */
    public void setCniPatientToConsult(String cniPatientToConsult) {
        this.cniPatientToConsult = cniPatientToConsult;
    }

    /**
     * @return the filteredConsultations
     */
    public List<Consultation> getFilteredConsultations() {
        return filteredConsultations;
    }

    /**
     * @param filteredConsultations the filteredConsultations to set
     */
    public void setFilteredConsultations(List<Consultation> filteredConsultations) {
        this.filteredConsultations = filteredConsultations;
    }

    /**
     * @return the filteredVaccins
     */
    public List<Consultation> getFilteredVaccins() {
        return filteredVaccins;
    }

    /**
     * @param filteredVaccins the filteredVaccins to set
     */
    public void setFilteredVaccins(List<Consultation> filteredVaccins) {
        this.filteredVaccins = filteredVaccins;
    }

    /**
     * @return the filteredExamens
     */
    public List<Consultation> getFilteredExamens() {
        return filteredExamens;
    }

    /**
     * @param filteredExamens the filteredExamens to set
     */
    public void setFilteredExamens(List<Consultation> filteredExamens) {
        this.filteredExamens = filteredExamens;
    }

    /**
     * @return the filteredCourriers
     */
    public List<Consultation> getFilteredCourriers() {
        return filteredCourriers;
    }

    /**
     * @param filteredCourriers the filteredCourriers to set
     */
    public void setFilteredCourriers(List<Consultation> filteredCourriers) {
        this.filteredCourriers = filteredCourriers;
    }

    /**
     * @return the filteredOrdonnances
     */
    public List<Consultation> getFilteredOrdonnances() {
        return filteredOrdonnances;
    }

    /**
     * @param filteredOrdonnances the filteredOrdonnances to set
     */
    public void setFilteredOrdonnances(List<Consultation> filteredOrdonnances) {
        this.filteredOrdonnances = filteredOrdonnances;
    }

    /**
     * @return the dateConvertibleConsult
     */
    public Date getDateConvertibleConsult() {
        return dateConvertibleConsult;
    }

    /**
     * @param dateConvertibleConsult the dateConvertibleConsult to set
     */
    public void setDateConvertibleConsult(Date dateConvertibleConsult) {
        this.dateConvertibleConsult = dateConvertibleConsult;
    }

    /**
     * @return the dateConvertibleOrdo
     */
    public Date getDateConvertibleOrdo() {
        return dateConvertibleOrdo;
    }

    /**
     * @param dateConvertibleOrdo the dateConvertibleOrdo to set
     */
    public void setDateConvertibleOrdo(Date dateConvertibleOrdo) {
        this.dateConvertibleOrdo = dateConvertibleOrdo;
    }

    /**
     * @return the dateConvertibleExam
     */
    public Date getDateConvertibleExam() {
        return dateConvertibleExam;
    }

    /**
     * @param dateConvertibleExam the dateConvertibleExam to set
     */
    public void setDateConvertibleExam(Date dateConvertibleExam) {
        this.dateConvertibleExam = dateConvertibleExam;
    }

    /**
     * @return the dateconvertibleVaccin
     */
    public Date getDateconvertibleVaccin() {
        return dateconvertibleVaccin;
    }

    /**
     * @param dateconvertibleVaccin the dateconvertibleVaccin to set
     */
    public void setDateconvertibleVaccin(Date dateconvertibleVaccin) {
        this.dateconvertibleVaccin = dateconvertibleVaccin;
    }

    /**
     * @return the dateConvertibleRappelVaccin
     */
    public Date getDateConvertibleRappelVaccin() {
        return dateConvertibleRappelVaccin;
    }

    /**
     * @param dateConvertibleRappelVaccin the dateConvertibleRappelVaccin to set
     */
    public void setDateConvertibleRappelVaccin(Date dateConvertibleRappelVaccin) {
        this.dateConvertibleRappelVaccin = dateConvertibleRappelVaccin;
    }

    /**
     * @return the patientByDoctor
     */
    public Patient getPatientByDoctor() {
        return patientByDoctor;
    }

    /**
     * @param patientByDoctor the patientByDoctor to set
     */
    public void setPatientByDoctor(Patient patientByDoctor) {
        this.patientByDoctor = patientByDoctor;
    }

    /**
     * @return the selectedConsultations
     */
    public List<Consultation> getSelectedConsultations() {
        return selectedConsultations;
    }

    /**
     * @param selectedConsultations the selectedConsultations to set
     */
    public void setSelectedConsultations(List<Consultation> selectedConsultations) {
        this.selectedConsultations = selectedConsultations;
    }

    /**
     * @return the selectConsultation
     */
    public Consultation getSelectConsultation() {
        return selectConsultation;
    }

    /**
     * @param selectConsultation the selectConsultation to set
     */
    public void setSelectConsultation(Consultation selectConsultation) {
        this.selectConsultation = selectConsultation;
    }

    /**
     * @return the conseilHealth_fl
     */
    public ConseilHealthFacadeLocal getConseilHealth_fl() {
        return conseilHealth_fl;
    }

    /**
     * @param conseilHealth_fl the conseilHealth_fl to set
     */
    public void setConseilHealth_fl(ConseilHealthFacadeLocal conseilHealth_fl) {
        this.conseilHealth_fl = conseilHealth_fl;
    }

    /**
     * @return the conseil
     */
    public ConseilHealth getConseil() {
        return conseil;
    }

    /**
     * @param conseil the conseil to set
     */
    public void setConseil(ConseilHealth conseil) {
        this.conseil = conseil;
    }

    /**
     * @return the selectedExam
     */
    public Examen getSelectedExam() {
        return selectedExam;
    }

    /**
     * @param selectedExam the selectedExam to set
     */
    public void setSelectedExam(Examen selectedExam) {
        this.selectedExam = selectedExam;
    }

    /**
     * @return the antecedent
     */
    public Antecedent getAntecedent() {
        return antecedent;
    }

    /**
     * @param antecedent the antecedent to set
     */
    public void setAntecedent(Antecedent antecedent) {
        this.antecedent = antecedent;
    }

    /**
     * @return the listConseilConsult
     */
    public List<ConseilHealth> getListConseilConsult() {
        return listConseilConsult;
    }

    /**
     * @param listConseilConsult the listConseilConsult to set
     */
    public void setListConseilConsult(List<ConseilHealth> listConseilConsult) {
        this.listConseilConsult = listConseilConsult;
    }

    /**
     * @return the listConseilExamen
     */
    public List<ConseilHealth> getListConseilExamen() {
        return listConseilExamen;
    }

    /**
     * @param listConseilExamen the listConseilExamen to set
     */
    public void setListConseilExamen(List<ConseilHealth> listConseilExamen) {
        this.listConseilExamen = listConseilExamen;
    }

    /**
     * @return the selectedConsultationConseil
     */
    public ConseilHealth getSelectedConsultationConseil() {
        return selectedConsultationConseil;
    }

    /**
     * @param selectedConsultationConseil the selectedConsultationConseil to set
     */
    public void setSelectedConsultationConseil(ConseilHealth selectedConsultationConseil) {
        this.selectedConsultationConseil = selectedConsultationConseil;
    }

    /**
     * @return the selectedExamenConseil
     */
    public ConseilHealth getSelectedExamenConseil() {
        return selectedExamenConseil;
    }

    /**
     * @param selectedExamenConseil the selectedExamenConseil to set
     */
    public void setSelectedExamenConseil(ConseilHealth selectedExamenConseil) {
        this.selectedExamenConseil = selectedExamenConseil;
    }

    /**
     * @return the filteredConsultationConseil
     */
    public List<ConseilHealth> getFilteredConsultationConseil() {
        return filteredConsultationConseil;
    }

    /**
     * @param filteredConsultationConseil the filteredConsultationConseil to set
     */
    public void setFilteredConsultationConseil(List<ConseilHealth> filteredConsultationConseil) {
        this.filteredConsultationConseil = filteredConsultationConseil;
    }

    /**
     * @return the dateConvertiblePublication
     */
    public Date getDateConvertiblePublication() {
        return dateConvertiblePublication;
    }

    /**
     * @param dateConvertiblePublication the dateConvertiblePublication to set
     */
    public void setDateConvertiblePublication(Date dateConvertiblePublication) {
        this.dateConvertiblePublication = dateConvertiblePublication;
    }

    /**
     * @return the dataScrollerRowIndex
     */
    
    /**
     * @return the subjectChoosed
     */
    public String getSubjectChoosed() {
        return subjectChoosed;
    }

    /**
     * @param subjectChoosed the subjectChoosed to set
     */
    public void setSubjectChoosed(String subjectChoosed) {
        this.subjectChoosed = subjectChoosed;
    }

    /**
     * @return the listDiscussionDoctor
     */
    public List<FilDiscussion> getListDiscussionDoctor() {
        return listDiscussionDoctor;
    }

    /**
     * @param listDiscussionDoctor the listDiscussionDoctor to set
     */
    public void setListDiscussionDoctor(List<FilDiscussion> listDiscussionDoctor) {
        this.listDiscussionDoctor = listDiscussionDoctor;
    }

    /**
     * @return the consultRecap
     */
    public List<Consultation> getConsultRecap() {
        return consultRecap;
    }

    /**
     * @param consultRecap the consultRecap to set
     */
    public void setConsultRecap(List<Consultation> consultRecap) {
        this.consultRecap = consultRecap;
    }

    /**
     * @return the ordoRecap
     */
    public List<Ordonnance> getOrdoRecap() {
        return ordoRecap;
    }

    /**
     * @param ordoRecap the ordoRecap to set
     */
    public void setOrdoRecap(List<Ordonnance> ordoRecap) {
        this.ordoRecap = ordoRecap;
    }

    /**
     * @return the email
     */
   

    /**
     * @return the numPatient
     */
    public String getNumPatient() {
        return numPatient;
    }

    /**
     * @param numPatient the numPatient to set
     */
    public void setNumPatient(String numPatient) {
        this.numPatient = numPatient;
    }

    /**
     * @return the messageSms
     */
    public String getMessageSms() {
        return messageSms;
    }

    /**
     * @param messageSms the messageSms to set
     */
    public void setMessageSms(String messageSms) {
        this.messageSms = messageSms;
    }

    /**
     * @return the dateConsultation
     */
    public Date getDateConsultation() {
        return dateConsultation;
    }

    /**
     * @param dateConsultation the dateConsultation to set
     */
    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    /**
     * @return the dateConvertible
     */
    public Date getDateConvertible() {
        return dateConvertible;
    }

    /**
     * @param dateConvertible the dateConvertible to set
     */
    public void setDateConvertible(Date dateConvertible) {
        this.dateConvertible = dateConvertible;
    }

    /**
     * @return the pompierList
     */
    public List<Pompier> getPompierList() {
        return pompierList;
    }

    /**
     * @param pompierList the pompierList to set
     */
    public void setPompierList(List<Pompier> pompierList) {
        this.pompierList = pompierList;
    }

    /**
     * @return the dateConvertibleForConsult
     */
    public Date getDateConvertibleForConsult() {
        return dateConvertibleForConsult;
    }

    /**
     * @param dateConvertibleForConsult the dateConvertibleForConsult to set
     */
    public void setDateConvertibleForConsult(Date dateConvertibleForConsult) {
        this.dateConvertibleForConsult = dateConvertibleForConsult;
    }

    /**
     * @return the dateFormatteConsult
     */
    public String getDateFormatteConsult() {
        return dateFormatteConsult;
    }

    /**
     * @param dateFormatteConsult the dateFormatteConsult to set
     */
    public void setDateFormatteConsult(String dateFormatteConsult) {
        this.dateFormatteConsult = dateFormatteConsult;
    }

    /**
     * @return the linkToRepConsultation
     */
    public String getLinkToRepConsultation() {
        return linkToRepConsultation;
    }

    /**
     * @param linkToRepConsultation the linkToRepConsultation to set
     */
    public void setLinkToRepConsultation(String linkToRepConsultation) {
        this.linkToRepConsultation = linkToRepConsultation;
    }

    /**
     * @return the emailfl
     */
    public EmailHealthcareFacadeLocal getEmailfl() {
        return emailfl;
    }

    /**
     * @param emailfl the emailfl to set
     */
    public void setEmailfl(EmailHealthcareFacadeLocal emailfl) {
        this.emailfl = emailfl;
    }

    /**
     * @return the emailHealth
     */
    public EmailHealthcare getEmailHealth() {
        return emailHealth;
    }

    /**
     * @param emailHealth the emailHealth to set
     */
    public void setEmailHealth(EmailHealthcare emailHealth) {
        this.emailHealth = emailHealth;
    }

    /**
     * @return the nomFichierCharge
     */
    public String getNomFichierCharge() {
        return nomFichierCharge;
    }

    /**
     * @param nomFichierCharge the nomFichierCharge to set
     */
    public void setNomFichierCharge(String nomFichierCharge) {
        this.nomFichierCharge = nomFichierCharge;
    }

    /**
     * @return the lienFichierCharge
     */
    public String getLienFichierCharge() {
        return lienFichierCharge;
    }

    /**
     * @param lienFichierCharge the lienFichierCharge to set
     */
    public void setLienFichierCharge(String lienFichierCharge) {
        this.lienFichierCharge = lienFichierCharge;
    }

    /**
     * @return the lienFichierGenere
     */
    public String getLienFichierGenere() {
        return lienFichierGenere;
    }

    /**
     * @param lienFichierGenere the lienFichierGenere to set
     */
    public void setLienFichierGenere(String lienFichierGenere) {
        this.lienFichierGenere = lienFichierGenere;
    }

    /**
     * @return the lienTelechargementDocConsultation
     */
    public String getLienTelechargementDocConsultation() {
        return lienTelechargementDocConsultation;
    }

    /**
     * @param lienTelechargementDocConsultation the lienTelechargementDocConsultation to set
     */
    public void setLienTelechargementDocConsultation(String lienTelechargementDocConsultation) {
        this.lienTelechargementDocConsultation = lienTelechargementDocConsultation;
    }

    /**
     * @return the lienTelechargementDocOrdonnance
     */
    public String getLienTelechargementDocOrdonnance() {
        return lienTelechargementDocOrdonnance;
    }

    /**
     * @param lienTelechargementDocOrdonnance the lienTelechargementDocOrdonnance to set
     */
    public void setLienTelechargementDocOrdonnance(String lienTelechargementDocOrdonnance) {
        this.lienTelechargementDocOrdonnance = lienTelechargementDocOrdonnance;
    }

    /**
     * @return the imagesWorker
     */
    public List<String> getImagesWorker() {
        return imagesWorker;
    }

    /**
     * @param imagesWorker the imagesWorker to set
     */
    public void setImagesWorker(List<String> imagesWorker) {
        this.imagesWorker = imagesWorker;
    }

    /**
     * @return the imagesAgri
     */
    public List<String> getImagesAgri() {
        return imagesAgri;
    }

    /**
     * @param imagesAgri the imagesAgri to set
     */
    public void setImagesAgri(List<String> imagesAgri) {
        this.imagesAgri = imagesAgri;
    }

    /**
     * @return the imageDemuni
     */
    public List<String> getImageDemuni() {
        return imageDemuni;
    }

    /**
     * @param imageDemuni the imageDemuni to set
     */
    public void setImageDemuni(List<String> imageDemuni) {
        this.imageDemuni = imageDemuni;
    }

    /**
     * @return the lienFichierChargeSms
     */
    public String getLienFichierChargeSms() {
        return lienFichierChargeSms;
    }

    /**
     * @param lienFichierChargeSms the lienFichierChargeSms to set
     */
    public void setLienFichierChargeSms(String lienFichierChargeSms) {
        this.lienFichierChargeSms = lienFichierChargeSms;
    }

    /**
     * @return the idSujetForum
     */
    public String getIdSujetForum() {
        return idSujetForum;
    }

    /**
     * @param idSujetForum the idSujetForum to set
     */
    public void setIdSujetForum(String idSujetForum) {
        this.idSujetForum = idSujetForum;
    }

    /**
     * @return the listDiscussionsPatient
     */
    public List<FilDiscussion> getListDiscussionsPatient() {
        return listDiscussionsPatient;
    }

    /**
     * @param listDiscussionsPatient the listDiscussionsPatient to set
     */
    public void setListDiscussionsPatient(List<FilDiscussion> listDiscussionsPatient) {
        this.listDiscussionsPatient = listDiscussionsPatient;
    }

    /**
     * @return the imagesUsager
     */
    public List<String> getImagesUsager() {
        return imagesUsager;
    }

    /**
     * @param imagesUsager the imagesUsager to set
     */
    public void setImagesUsager(List<String> imagesUsager) {
        this.imagesUsager = imagesUsager;
    }

    /**
     * @return the cniSocialPatient
     */
    public String getCniSocialPatient() {
        return cniSocialPatient;
    }

    /**
     * @param cniSocialPatient the cniSocialPatient to set
     */
    public void setCniSocialPatient(String cniSocialPatient) {
        this.cniSocialPatient = cniSocialPatient;
    }

    /**
     * @return the publicCompany
     */
    public List<String> getPublicCompany() {
        return publicCompany;
    }

    /**
     * @param publicCompany the publicCompany to set
     */
    public void setPublicCompany(List<String> publicCompany) {
        this.publicCompany = publicCompany;
    }

    /**
     * @return the privateCompany
     */
    public List<String> getPrivateCompany() {
        return privateCompany;
    }

    /**
     * @param privateCompany the privateCompany to set
     */
    public void setPrivateCompany(List<String> privateCompany) {
        this.privateCompany = privateCompany;
    }

    /**
     * @return the selectedCompany
     */
    public String[] getSelectedCompany() {
        return selectedCompany;
    }

    /**
     * @param selectedCompany the selectedCompany to set
     */
    public void setSelectedCompany(String[] selectedCompany) {
        this.selectedCompany = selectedCompany;
    }

    /**
     * @return the linkDownload
     */
  

    

}
