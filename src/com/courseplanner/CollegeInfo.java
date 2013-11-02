package com.courseplanner;

import java.util.ArrayList;

import com.google.appengine.api.datastore.*;

public class CollegeInfo {

	public void insertCollegeInfo() {
		System.out.println("MOAR MUTHA FUCKIN BASS!!!!");

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		// PersistenceManagerFactory PMF =
		// JDOHelper.getPersistenceManagerFactory("jdo.properties");
		// PersistenceManager pm = PMF.getPersistenceManager();
		// Transaction txn = datastore.beginTransaction();

		String[] muirGE = { "MCWP 40", "MCWP 50" };
		ArrayList<Entity> entities_to_write = new ArrayList<Entity>();

		// Strings of table html for misc GEs
		Text area1 = new Text(
				"<table><tbody> <tr> <td>Sequence</td> <td>Course 1</td> <td>Course 2</td> <td>Course 3</td> </tr> <tr> <td><sup>Anthropology</sup></td> <td>ANTH 1</td> <td>ANTH 2</td> <td>ANTH 3</td> </tr> <tr> <td><sup>Cognitive Science</sup></td> <td>COGS 1</td> <td>COGS 11</td> <td>COGS 10 or<br> COGS 17</td> </tr> <tr> <td><sup>Critical Gender Studies</sup></td> <td>CGS 2A</td> <td>CGS 2B</td> <td>CGS 100</td> </tr> <tr> <td><sup>Economics</sup></td> <td>ECON 1</td> <td>ECON 2</td> <td>ECON 3</td> </tr> <tr> <td><sup>Ethnic Studies</sup></td> <td>ETHN 1</td> <td>ETHN 2</td> <td>ETHN 3</td> </tr> <tr> <td><sup>Linguistics</sup></td> <td>Choose 3 from LIGN 3, 4, 7, or 8</td> </tr> <tr> <td><sup>Political Science</sup></td> <td>Choose 3 from POLI 10, 11, 12, or 13</td> </tr> <tr> <td><sup>Psychology</sup></td> <td>Choose 3 from PSYC 1, 2, 3, 4, 6, or 7</td> </tr> <tr> <td><sup>Sociology</sup></td> <td>SOCI 1</td> <td>SOCI 2</td> <td>One from SOCI 10, 20, 30, 40 or 50</td> </tr> <tr> <td><sup>Urban Studies &amp; Planning</sup></td> <td>USP 1</td> <td>USP 2</td> <td>USP 3</td> </tr> </tbody></table>");
		Text area2 = new Text(
				"<table><tbody> <tr> <td>Sequence</td> <td>Course 1</td> <td>Course 2</td> <td>Course 3</td> </tr> <tr> <td><sup>Biology (non-science majors)</sup></td> <td>BILD 10</td> <td>Choose 2 from BILD 7, 12, 20, 22, 24, 26, 30, 32, or 36</td> </tr> <tr> <td><sup>Calculus</sup></td> <td>MATH 10A</td> <td>MATH 10B</td> <td>MATH 10C</td> </tr> <tr> <td><sup>Calculus (engineering)</sup></td> <td>MATH 20A</td> <td>MATH 20B</td> <td>MATH 20C</td> </tr> <tr> <td><sup>Chemistry (non-science majors)</sup></td> <td>CHEM 11</td> <td>CHEM 12</td> <td>CHEM 13</td> </tr> <tr> <td><sup>Chemistry</sup></td> <td>CHEM 6A</td> <td>CHEM 6B</td> <td>CHEM 6C</td> </tr> <tr> <td><sup>Earth Science (non-science majors)</sup></td> <td>Choose 3 from SIO 1, 10, 20 or 30</td> </tr> <tr> <td><sup>Environmental Studies (non-science majors)</sup></td> <td>ENVR 30</td> <td>Choose 2 from BILD 18, PHYS 12, or SIO 25</td> </tr> <tr> <td><sup><span>Environmental Studies (non-science majors)</span></sup></td> <td>ENVR 30</td> <td>One from BILD 18, PHYS 12, or SIO 25</td> <td>ENVR 130 or 140</td> </tr> <tr> <td><sup>Physics (biological sciences)</sup></td> <td>PHYS 1A+1AL</td> <td>PHYS 1B+1BL</td> <td>PHYS 1C+1CL</td> </tr> <tr> <td><sup>Physics (engineering)</sup></td> <td>PHYS 2A</td> <td>PHYS 2B</td> <td>PHYS 2C</td> </tr> <tr> <td><sup>Physics (non-science majros)</sup></td> <td>Choose 3 from PHYS 5, 6, 7, 8, 9, 10, or 11</td> </tr> <tr> <td><sup>Physics (physics majors)</sup></td> <td>PHYS 4A</td> <td>PHYS 4B</td> <td>PHYS 4C</td> </tr> </tbody></table>");
		Text area3 = new Text(
				"<table><tbody> <tr> <td>Sequence</td> <td>Course 1</td> <td>Course 2</td> <td>Course 3</td> </tr> <tr> <td><sup>Art History</sup></td> <td>Choose 3 from VIS 20, 21A, 21B, or 22</td> </tr> <tr> <td><sup>Film Studies</sup></td> <td>VIS 22</td> <td>VIS 84</td> <td>One from VIS 152, 153, 154, or 155</td> </tr> <tr> <td><sup>Music Fundamentals</sup></td> <td>MUS 1A</td> <td>MUS 1B</td> <td>MUS 1C</td> </tr> <tr> <td><sup>Music Traditions</sup></td> <td>MUS 4</td> <td>Choose 2 from MUS 5, 7, 8, 9, 10, 11, 12, 13AF, 13AM, 13AS, 14, or 15</td> </tr> <tr> <td><sup>Theatre History</sup></td> <td>Choose 3 from TDHT 10, 21, 22 or 23</td> </tr> <tr> <td><sup>Theatre</sup></td> <td>TDGE 1</td> <td>Choose 2 from TDAC 1, TDDE 1, TDGE 10 or TDPW 1</td> </tr> <tr> <td><sup>Visual Arts</sup></td> <td>Choose 2 from&nbsp;VIS 1, 2, or 3</td> <td>VIS 111</td> </tr> </tbody></table><table> <tbody> <tr> <td>Sequence</td> <td>Course 1</td> <td>Course 2</td> <td>Course 3</td> </tr> <tr> <td><sup>American Sign Language</sup></td> <td>Choose 3 from<br> LISL 1A+1AX, 1B+1BX, 1C+1CX, or 1D+1DX</td> </tr> <tr> <td><sup>Ancient Greek</sup></td> <td>LTGK 1</td> <td>LTGK 2</td> <td>LTGK 3</td> </tr> <tr> <td><sup>Arabic</sup></td> <td>LIAB 1A+1AX</td> <td>LIAB 1B+1BX</td> <td>LIAB 1C+1CX</td> </tr> <tr> <td><sup>Chinese</sup></td> <td>Choose 3 from<br> CHIN 10A, 10 B, 10C, 20A, 20B, or 20C</td> </tr> <tr> <td><sup>French</sup></td> <td>Choose 3 from&nbsp;LIFR 1A+1AX, 1B+1BX, 1C+1CX, or 1D+1DX; or&nbsp;<span>LTFR 2A, 2B, 2C, or 50</span></td> </tr> "
						+ "<tr> <td><sup>German</sup></td> <td>Choose 3 from&nbsp;LIGM 1A+1AX<span>, 1B+1BX, 1C+1CX, or 1D+1DX; or LTFR 2A, 2B, 2C or 50</span></td> </tr> <tr> <td><sup>Hebrew</sup></td> <td>JUDA 1</td> <td>JUDA 2</td> <td>JUDA 3</td> </tr> <tr> <td><sup>Italian</sup></td> <td><span>Choose 3 from&nbsp;LIIT 1A+1AX</span><span>, 1B+1BX, 1C+1CX, or 1D+1DX; or LTIT 2A, 2B or 50</span></td> </tr> <tr> <td><sup>Japanese</sup></td> <td>Choose 3 from<br> JAPN 10A, 10B, 10C, 20A, 20B, or 20C</td> </tr> <tr> <td><sup>Korean</sup></td> <td>Choose 3 from LTKO 1A, 1B, 1C, 2A, 2B, or 2C</td> </tr> <tr> <td><sup>Latin</sup></td> <td>LTLA 1</td> <td>LTLA 2</td> <td>LTLA 3</td> </tr> <tr> <td><sup>Portuguese</sup></td> <td>LIPO 1A+1AX</td> <td>LIPO 1B+1BX</td> <td>LIPO 1C+1CX</td> </tr> <tr> <td><sup>Russian</sup></td> <td>Choose 3 from LTRU 1A, 1B, 1C, 2A, 2B, or 2C</td> </tr> <tr> <td><sup>Spanish</sup></td> <td><span>Choose 3 from&nbsp;LISP 1A+1AX</span><span>, 1B+1BX, 1C+1CX, or 1D+1DX; LISP 2A, 2B, 2C, 2D, 2E, 50A, 50B, or 50C</span></td> </tr> </tbody> </table><table> <tbody> <tr> <td>Sequence</td> <td>Course 1</td> <td>Course 2</td> <td>Course 3</td> </tr> <tr> <td><sup>British &amp; American Literature</sup></td> <td>Choose 3 from LTEN 22, 23, 25, or 26</td> </tr> <tr> <td><sup>Fiction &amp; Film in 20th Century</sup></td> <td>Choose 3 from LTWL 4A, 4B, 4C, 4D, 4F, or 4M</td> </tr> <tr> <td><sup>Fiction, Poetry, &amp; Non-Fiction Writing</sup></td> <td>LTWR 8A</td> <td>LTWR 8B</td> <td>LTWR 8C</td> </tr> <tr> <td><sup>History of China and"
						+ " Japan</sup></td> <td>HILD 10</td> <td>HILD 11</td> <td>HILD 12</td> </tr> <tr> <td><sup>History of Philosophy</sup></td> <td>PHIL 31</td> <td>PHIL 32</td> <td>PHIL 33</td> </tr> <tr> <td><sup>Introduction to Greeks &amp; Romans</sup></td> <td>LTWL 19A</td> <td>LTWL 19B</td> <td>LTWL 19C</td> </tr> <tr> <td><sup>Introduction to Philosophy</sup></td> <td>Choose 3 from PHIL 1, 13, 14, or 15</td> </tr> <tr> <td><sup>Race &amp; Ethnicity in U.S. History</sup></td> <td>HILD 7A</td> <td>HILD 7B</td> <td>HILD 7C</td> </tr> <tr> <td><sup>Race &amp; Ethnicity in U.S. Literature</sup></td> <td>LTEN 27</td> <td>LTEN 28</td> <td>LTEN 29</td> </tr> <tr> <td><sup>Third World Literature</sup></td> <td>Choose 3 from TWS 21, 22, 23, 24, 25 or 26</td> </tr> <tr> <td><sup>U.S. History</sup></td> <td>HILD 2A</td> <td>HILD 2B</td> <td>HILD 2C</td> </tr> </tbody> </table>");

		Entity college = new Entity("collegeTable");
		datastore.put(college);

		Entity Muir = new Entity("College", college.getKey());
		datastore.put(Muir);

		Muir.setProperty("name", "Muir");
		Muir.setProperty(
				"description",
				"Muir College encourages awareness of environmental "
						+ "issues and involvement in environmental preservation and "
						+ "sustainability.");
		// Muir.setProperty("geReqs", muirGE);
		for (int i = 0; i < muirGE.length; i++) {
			Entity muirGEReq = new Entity("GEReqCourse", Muir.getKey());
			muirGEReq.setProperty("CourseID", muirGE[i]);
			entities_to_write.add(muirGEReq);
		}

		Entity muir_misc_GEReq = new Entity("MiscGEReqCourse", Muir.getKey());
		muir_misc_GEReq.setProperty("Area 1", area1);
		muir_misc_GEReq.setProperty("Area 2", area2);
		muir_misc_GEReq.setProperty("Area 3", area3);
		entities_to_write.add(muir_misc_GEReq);

		datastore.put(entities_to_write);

		// Util.persistEntity(college);
		// Util.persistEntity(Muir);
	}
}
